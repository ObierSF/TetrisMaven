package com.tetris;

/**
 * Created by User on 09.03.2016.
 */
class NonBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return border == null;
    }

    public Border getBorder() {
        return Border.NONBORDER;
    }
}
