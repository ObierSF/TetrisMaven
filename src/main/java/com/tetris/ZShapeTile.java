package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class ZShapeTile extends Tile {
    ZShapeTile(Board board) {
        super(board);
        color = "ORANGE";
        fields = new ArrayList<Field>(4);
        fieldsID = new int[4];
    }

    @Override
    void setFields() {
        fields.add(board.getField(5));
        fields.add(board.getField(14));
        fields.add(board.getField(15));
        fields.add(board.getField(24));
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {

    }

    @Override
    void rotateRight() {

    }
}