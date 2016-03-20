package com.tetris;

/**
 * Created by User on 06.03.2016.
 */
public class ZShapeTile extends Tile {
    ZShapeTile(Board board) {
        super(board);
        color = "ORANGE";
        int[] iShapePosition = {5, 14, 15, 24};
        setUpFields(iShapePosition);
    }

    @Override
    void rotateLeft() {

    }

    @Override
    void rotateRight() {

    }
}