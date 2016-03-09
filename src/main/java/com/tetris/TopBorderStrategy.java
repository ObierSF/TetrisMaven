package com.tetris;

/**
 * Created by User on 09.03.2016.
 */
class TopBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position > 0 && position < width-1);
    }

    public Border getBorder() {
        return Border.TOP;
    }
}
