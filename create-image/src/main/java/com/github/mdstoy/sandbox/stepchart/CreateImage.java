package com.github.mdstoy.sandbox.stepchart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CreateImage {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("sm file name!!");
            System.exit(1);
        }
        new CreateImage().execute(args[0]);
    }

    public void execute(String filename) {
        // TODO : validate filename

        try(Stream<String> lines = Files.lines(Paths.get(filename))){

            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
