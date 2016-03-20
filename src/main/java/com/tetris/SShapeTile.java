package com.tetris;

/**
 * Created by User on 06.03.2016.
 */
public class SShapeTile extends Tile {
    SShapeTile(Board board) {
        super(board);
        color = "GRAY";
        int[] iShapePosition = {4, 14, 15, 25};
        setUpFields(iShapePosition);
    }

    @Override
    void rotateLeft() {

    }

    @Override
    void rotateRight() {

    }
}