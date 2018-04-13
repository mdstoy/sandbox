package com.github.mdstoy.sandbox.stepchart.data;

import java.util.List;

public class Measure {

    private List<String> beats;

    public Measure(List<String> beats) {
        this.beats = beats;
    }

    public int resolution() {
        return beats.size();
    }
}
