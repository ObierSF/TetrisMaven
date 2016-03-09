package com.tetris;

/**
 * Created by User on 09.03.2016.
 */
class LTCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == 0;
    }

    public Border getBorder() {
        return Border.LTCORNER;
    }
}
