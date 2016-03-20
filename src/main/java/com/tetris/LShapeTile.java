package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class LShapeTile extends Tile {
    LShapeTile(Board board) {
        super(board);
        color = "PINK";
        int[] iShapePosition = {4, 14, 24, 25};
        setUpFields(iShapePosition);
    }

    @Override
    void rotateLeft() {
        if(isVertical()) {

        }
        else {

        }
    }

    @Override
    void rotateRight() {

    }
}