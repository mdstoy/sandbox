package com.github.mdstoy.sandbox.image;

public enum Position {
    ONE_P_LEFT(0), ONE_P_DOWN(1), ONE_P_UP(2), ONE_P_RIGHT(3),
    TWO_P_LEFT(4), TWO_P_DOWN(5), TWO_P_UP(6), TWO_P_RIGHT(7);

    private int value;

    Position(int value) {
        this.value = value;
    }

    public int position() {
        return value;
    }

}
