package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
class JShapeTile extends Tile {

    JShapeTile(Board board) {
        super(board);
        color = "GREEN";
        fields = new ArrayList<Field>(4);
        fieldsID = new int[4];
    }

    @Override
    void setFields() {
        fields.add(board.getField(5));
        fields.add(board.getField(15));
        fields.add(board.getField(24));
        fields.add(board.getField(25));
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {

    }

    @Override
    void rotateRight() {

    }
}
