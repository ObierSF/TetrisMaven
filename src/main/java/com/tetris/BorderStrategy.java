package com.tetris;

/**
 * Created by User on 08.03.2016.
 */
interface BorderStrategy {
    boolean validate(int width, int height, int position, Border border);
    Border getBorder();
}

class LTCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == 0;
    }

    public Border getBorder() {
        return Border.LTCORNER;
    }
}

class RTCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == width-1;
    }

    public Border getBorder() {
        return Border.RTCORNER;
    }
}

class LBCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == (height * width) - width;
    }

    public Border getBorder() {
        return Border.LBCORNER;
    }
}

class RBCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == (height * width)-1;
    }

    public Border getBorder() {
        return Border.RBCORNER;
    }
}

class LeftBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position > 0 && position < (width * height) - width && position % width == 0);
    }

    public Border getBorder() {
        return Border.LEFT;
    }
}

class RightBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position > width-1 && position < (height * width)-1 && position % width == 9);
    }

    public Border getBorder() {
        return Border.RIGHT;
    }
}

class TopBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position > 0 && position < width-1);
    }

    public Border getBorder() {
        return Border.TOP;
    }
}

class BottomBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position < (width * height)-1 && position > (width * height) - width);
    }

    public Border getBorder() {
        return Border.BOTTOM;
    }
}

class NonBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return border == null;
    }

    public Border getBorder() {
        return Border.NONBORDER;
    }
}