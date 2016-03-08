package com.tetris;

/**
 * Created by User on 06.03.2016.
 */
public class Field {
    final int height = 16;
    final int width = 10;
    boolean isPartOfTile;
    boolean isLocated;
    int position;
    String color;
    Border border;

    Field(int position) {
        this.position = position;
        isPartOfTile = false;
        isLocated = false;
        //checkBorder();
    }

    void checkBorder() {
        if (position == 0)
            border = Border.LTCORNER;
        else if (position == width - 1)
            border = Border.RTCORNER;
        else if (position == (width * height) - 1 - width)
            border = Border.LBCORNER;
        else if (position == (width * height)-1)
            border = Border.RBCORNER;
        else if (position % width == 0)
            border = Border.LEFT;
        else if (position % width == width-1)
            border = Border.RIGHT;
        else if (position < width)
            border = Border.TOP;
        else if (position >= (width * height) - width && position > width * height)
            border = Border.BOTTOM;
        else
            border = Border.NONBORDER;
    }

    void locate() {
        isPartOfTile = false;
        isLocated = true;
    }

    void makePartOfTile(String color) {
        this.color = color;
        isPartOfTile = true;
        isLocated = false;
    }

    void empty() {
        color = "";
        isPartOfTile = false;
        isLocated = false;
    }

    boolean isEmpty() {
        if (isLocated || isPartOfTile) {
            return false;
        }
        return true;
    }

    int getPosition() {
        return position;
    }
}