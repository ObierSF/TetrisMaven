package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class LShapeTile extends Tile {
    LShapeTile(Board board) {
        super(board);
        color = "PINK";
        fields = new ArrayList<Field>();
    }

    @Override
    void setFields() {
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
        fields.add(board.getField(25));
        makeFieldsPartOfTile();
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