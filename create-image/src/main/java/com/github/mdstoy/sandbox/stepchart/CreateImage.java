package com.github.mdstoy.sandbox.stepchart;

import com.github.mdstoy.sandbox.stepchart.data.Beat;
import com.github.mdstoy.sandbox.stepchart.data.BeatPosition;
import com.github.mdstoy.sandbox.stepchart.data.Measure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

            List<Beat> hoge = lines.map(Beat::of).collect(Collectors.toList());

            for(Beat beat : hoge) {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }


    private List<Measure> read(String line) {
        return null;
    }
}
