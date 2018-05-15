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
        Arrow arrow = Arrow.of("down.png");

        Graphics2D graphics1 = null;

        try {

            // 読み込んだイメージを操作できるように
            graphics1 = bufferedImage1.createGraphics();

            // イメージを重ねる
            graphics1.drawImage(arrow.image, 0, 0, null);

            // 変換元 -> 変換先
            arrow.changeColor(255, 0, 0);
            graphics1.drawImage(arrow.rotate(90), 92, 48, null);
            graphics1.drawImage(arrow.rotate(180), 48, 70, null);

        } finally {

            graphics1.dispose();
        }

        ImageIO.write(bufferedImage1, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }
}
