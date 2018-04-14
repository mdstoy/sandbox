package com.github.mdstoy.sandbox.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.stream.IntStream;

public class Extend {

    public static void main(String[] args) throws Exception {
        new Extend().execute(3);
    }

    public void execute(int measures) throws Exception{

        BufferedImage background = ImageIO.read(new File("back.png"));
        BufferedImage result = new BufferedImage(background.getWidth(), background.getHeight() * measures, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics1 = result.createGraphics();

        try {
            IntStream.range(0, measures)
                    .forEach(i -> graphics1.drawImage(background, 0, 192 * i, null));

        } finally {

            graphics1.dispose();
        }

        ImageIO.write(result, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }
}
