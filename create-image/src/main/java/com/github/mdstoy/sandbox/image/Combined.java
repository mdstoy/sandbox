package com.github.mdstoy.sandbox.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class Combined {

    public static void main(String[] args) throws Exception {
        new Combined().execute();
    }

    public void execute() throws Exception{

        BufferedImage bufferedImage1 = ImageIO.read(new File("back.png"));
        BufferedImage bufferedImage2 = ImageIO.read(new File("down.png"));

        Graphics2D graphics1 = null;
        Graphics2D graphics2 = null;

        try {

            // 読み込んだイメージを操作できるように
            graphics1 = bufferedImage1.createGraphics();

            // イメージを重ねる
            graphics1.drawImage(bufferedImage2, 0, 0, null);

            // 書き出し用
            BufferedImage bufferedImage3 = new BufferedImage(48, 48, BufferedImage.TYPE_INT_ARGB);

            graphics2 = bufferedImage2.createGraphics();
            // 変換の設定
            AffineTransform at = new AffineTransform();
            at.setToRotation(Math.toRadians(90), 24d, 24d);

            // 変換の実操作
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
            // 変換元 -> 変換先
            op.filter(bufferedImage2, bufferedImage3);
            graphics1.drawImage(bufferedImage3, 92, 48, null);
            bufferedImage3 = changeColor(bufferedImage3);
            graphics1.drawImage(bufferedImage3, 48, 66, null);

        } finally {

            graphics1.dispose();
            graphics2.dispose();
        }

        ImageIO.write(bufferedImage1, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }

    private BufferedImage changeColor(BufferedImage image) {
        for(int i = 0; i < image.getHeight(); ++i) {
            int rgb = image.getRGB(i, 24);
            System.out.println(rgb + "/" + ((rgb >> 16) & 0xff) + "/" + ((rgb >> 8) & 0xff) + "/" + (rgb & 0xff));
            for(int j = 0; j < image.getWidth(); ++j) {
                if (image.getRGB(i, j) == -16777216) {
                    image.setRGB(i, j, (128 << 16) + (16 << 8) + 16);
                }
            }
        }
        System.out.println((128 << 16) + (16 << 8) + 16);

        return image;
    }
}
