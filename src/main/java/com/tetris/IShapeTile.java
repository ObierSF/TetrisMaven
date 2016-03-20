package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class IShapeTile extends Tile {
    IShapeTile(Board board) {
        super(board);
        color = "RED";
        int[] iShapePosition = {4, 14, 24, 34};
        setUpFields(iShapePosition);
    }

    @Override
    void rotateLeft() {
    }

    @Override
    void rotateRight() {
    }
}