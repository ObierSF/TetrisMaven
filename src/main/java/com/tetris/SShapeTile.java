package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class SShapeTile extends Tile {
    SShapeTile(Board board) {
        super(board);
        color = "GRAY";
        fields = new ArrayList<Field>(4);
        fieldsID = new int[4];
    }

    @Override
    void setFields() {
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(15));
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