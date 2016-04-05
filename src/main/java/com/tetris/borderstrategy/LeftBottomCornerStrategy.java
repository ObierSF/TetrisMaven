package com.tetris.borderstrategy;

import com.tetris.Border;

/**
 * Created by User on 09.03.2016.
 */
public class LeftBottomCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == (height * width) - width;
    }

    public Border getBorder() {
        return Border.LEFTBOTTOMCORNER;
    }
}