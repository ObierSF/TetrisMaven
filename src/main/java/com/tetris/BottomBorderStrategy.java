package com.tetris;

/**
 * Created by User on 09.03.2016.
 */
class BottomBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position < (width * height)-1 && position > (width * height) - width);
    }

    public Border getBorder() {
        return Border.BOTTOM;
    }
}
