package com.github.mdstoy.sandbox.stepchart.data;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Beat {
    private Set<BeatPosition> positions;

    private static final Map<Integer, BeatPosition> conv = Map.of(
            0, BeatPosition.P1_LEFT,
            1, BeatPosition.P1_DOWN,
            2, BeatPosition.P1_UP,
            3, BeatPosition.P1_RIGHT,
            4, BeatPosition.P2_LEFT,
            5, BeatPosition.P2_DOWN,
            6, BeatPosition.P2_UP,
            7, BeatPosition.P2_RIGHT
    );

    private Beat(Set<BeatPosition> positions) {
        this.positions = positions;
    }

    public static Beat of(String line) {

        if (line.equals(",")) {
            return new MeasureSepalator(null);
        }


        Set<BeatPosition> p = IntStream.range(0, line.length())
                .filter(i -> line.charAt(i) == '1')
                .mapToObj(i -> conv.get(i))
                .collect(Collectors.toSet());

        return new Beat(p);
    }

    private static class MeasureSepalator extends Beat {

        private MeasureSepalator(Set<BeatPosition> positions) {
            super(positions);
        }


    }
}
