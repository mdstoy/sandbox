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

        Background background = Background.of("back.png");
        Arrow arrow = Arrow.of("down.png");

        // TODO : これ Background にしまう
        Graphics2D graphics1 = null;

        try {

            // 読み込んだイメージを操作できるように
            graphics1 = background.image.createGraphics();

            // イメージを重ねる
            // TODO : これ Background にしまう
            graphics1.drawImage(arrow.image, 0, 0, null);

            // 変換元 -> 変換先
            // TODO : これ Background にしまう
            arrow.changeColor(255, 255, 0);
            graphics1.drawImage(arrow.rotate(90), 92, 48, null);
            graphics1.drawImage(arrow.rotate(180), 48, 70, null);

        } finally {

            graphics1.dispose();
        }

        background.output();
    }
}
