package com.tetris;

/**
 * Created by User on 07.03.2016.
 */
public enum Border {
    LTCORNER(0),
    RTCORNER(9),
    LBCORNER(150),
    RBCORNER(159),
    LEFT(10),
    RIGHT(19),
    TOP(1),
    BOTTOM(151),
    NONBORDER(55);

    int n;

    Border (int n) {
        this.n = n;
    }
}
