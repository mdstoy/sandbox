package com.github.mdstoy.sandbox.image;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Arrow {

    BufferedImage image;

    private Arrow(String imagePath) {
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch(IOException ioe) {
            // noop
        }

    }

    public static Arrow of(String imagePath) {
        return new Arrow(imagePath);
    }

    // FIXME : インスタンスの扱い
    public BufferedImage changeColor(int r, int g, int b) {
        for(int i = 0; i < image.getHeight(); ++i) {
            for(int j = 0; j < image.getWidth(); ++j) {
                if (image.getRGB(i, j) == -16777216) {
                    image.setRGB(i, j, (255 << 24) + (r << 16) + (g << 8) + b);
                } else {
                    image.setRGB(i, j, 0);
                }
            }
        }

        return image;
    }

    public BufferedImage rotate(int angle) {
        // 変換の設定
        AffineTransform at = new AffineTransform();
        // TODO : 24d は取ってくる？
        at.setToRotation(Math.toRadians(angle), 24d, 24d);
        // 変換の実操作
        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);

        // 書き出し用
        // TODO : 48 は取ってくる
        BufferedImage newImage = new BufferedImage(48, 48, BufferedImage.TYPE_INT_ARGB);
        op.filter(image, newImage);

        return newImage;
    }
}
