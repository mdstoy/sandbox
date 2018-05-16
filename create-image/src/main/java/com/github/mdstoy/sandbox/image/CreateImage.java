package com.github.mdstoy.sandbox.image;

public class CreateImage {

    public static void main(String[] args) throws Exception {
        new CreateImage().execute();
    }

    public void execute() throws Exception{

        Background background = Background.of("back.png");
        Arrow arrow = Arrow.of("down.png");

        try {

            background.put(arrow, 1, 1, Position.ONE_P_LEFT);

            background.put(arrow, 1, 3, Position.ONE_P_UP);

        } finally {

            background.dispose();
        }

        background.output();
    }
}
