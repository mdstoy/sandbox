package com.github.mdstoy.sandbox.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background {
    BufferedImage image;

    private Background(String imagePath) {
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch(IOException ioe) {
            // noop
        }

    }

    public static Background of(String imagePath) {
        return new Background(imagePath);
    }

    public void output() throws IOException {
        ImageIO.write(image, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }
}
