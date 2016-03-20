package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
class JShapeTile extends Tile {

    JShapeTile(Board board) {
        super(board);
        color = "GREEN";
        int[] jShapePosition = {5, 15, 24, 25};
        setUpFields(jShapePosition);
    }

    @Override
    void rotateLeft() {

    }

    @Override
    void rotateRight() {

    }
}
