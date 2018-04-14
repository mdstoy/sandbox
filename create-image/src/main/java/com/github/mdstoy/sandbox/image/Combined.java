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

            graphics1 = bufferedImage1.createGraphics();

            graphics1.drawImage(bufferedImage2, 0, 0, null);

            BufferedImage bufferedImage3 = new BufferedImage(48, 48, BufferedImage.TYPE_INT_ARGB);
            graphics2 = bufferedImage2.createGraphics();
            AffineTransform at = new AffineTransform();
            at.setToRotation(Math.toRadians(90), 24d, 24d);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
            op.filter(bufferedImage2, bufferedImage3);
            graphics1.drawImage(bufferedImage3, 48, 0, null);

        } finally {

            graphics1.dispose();
            graphics2.dispose();
        }

        ImageIO.write(bufferedImage1, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }
}
