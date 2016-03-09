package com.tetris;

/**
 * Created by User on 09.03.2016.
 */
class RBCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == (height * width)-1;
    }

    public Border getBorder() {
        return Border.RBCORNER;
    }
}