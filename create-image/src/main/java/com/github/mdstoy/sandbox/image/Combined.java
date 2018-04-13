package com.github.mdstoy.sandbox.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
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

            graphics1 = bufferedImage1.createGraphics();

            graphics1.drawImage(bufferedImage2, 0, 0, null);

            BufferedImage bufferedImage3 = ImageIO.read(new File("down.png"));
            graphics2 = bufferedImage3.createGraphics();
            AffineTransform at = new AffineTransform();
            at.setToRotation(90 * Math.PI/180, 24d, 24d);
            graphics2.drawImage(bufferedImage3, at, null);
            graphics1.drawImage(bufferedImage3, 48, 0, null);

        } finally {

            graphics1.dispose();
            graphics2.dispose();
        }

        ImageIO.write(bufferedImage1, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }
}
