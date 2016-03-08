package com.tetris;

/**
 * Created by User on 08.03.2016.
 */
interface BorderStrategy {
    Border getBorder(int width, int height, int position);
}

class LTCornerStrategy implements BorderStrategy {
    public Border getBorder(int width, int height, int position) {
        if (position == 0) {
            return Border.LTCORNER;
        }
        return null;
    }
}

class RTCornerStrategy implements BorderStrategy {
    public Border getBorder(int width, int height, int position) {
        if (position == width-1) {
            return Border.RTCORNER;
        }
        return null;
    }
}

class LBCornerStrategy implements BorderStrategy {
    public Border getBorder(int width, int height, int position) {
        if (position == (height * width) - width) {
            return Border.LBCORNER;
        }
        return null;
    }
}

class RBCornerStrategy implements BorderStrategy {
    public Border getBorder(int width, int height, int position) {
        if (position == (height * width)-1) {
            return Border.RBCORNER;
        }
        return null;
    }
}

class LeftBorderStrategy implements BorderStrategy {
    public Border getBorder(int width, int height, int position) {
        if (position > 0 && position < (width * height) - width && position % width == 0) {
            return Border.LEFT;
        }
        return null;
    }
}

class RightBorderStrategy implements BorderStrategy {
    public Border getBorder(int width, int height, int position) {
        if (position > width-1 && position < (height * width)-1 && position % width == 9) {
            return Border.RIGHT;
        }
        return null;
    }
}

class TopBorderStrategy implements BorderStrategy {
    public Border getBorder(int width, int height, int position) {
        if (position > 0 && position < width-1) {
            return Border.TOP;
        }
        return null;
    }
}

class BottomBorderStrategy implements BorderStrategy {
    public Border getBorder(int width, int height, int position) {
        if (position < (width * height)-1 && position > (width * height) - width) {
            return Border.BOTTOM;
        }
        return null;
    }
}