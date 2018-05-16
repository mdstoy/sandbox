package com.github.mdstoy.sandbox.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// FIXME : こうなると Background という名前があれやな
public class Background {
    private BufferedImage image;
    Graphics2D graphics = null;

    private Background(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
            // 読み込んだイメージを操作できるように
            graphics = image.createGraphics();

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

    // TODO : 四分以外を表現せないかん
    public void put(Arrow arrow, int measure, int beat, Position position) {
        // TODO : 場所に合わせて色と向きを変えなきゃいかん
        puta(arrow, (measure - 1) * 192 + (beat - 1) * 48, position.position() * 48);
    }

    private void puta(Arrow arrow, int x, int y) {
        graphics.drawImage(arrow.image, x, y, null);
    }

    public void dispose() {
        graphics.dispose();
    }
    /*

            // 変換元 -> 変換先
            arrow.changeColor(255, 255, 0);
            graphics.drawImage(arrow.rotate(90), 92, 48, null);
            graphics.drawImage(arrow.rotate(180), 48, 70, null);
     */
}
