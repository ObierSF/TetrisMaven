package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class OShapeTile extends Tile {
    OShapeTile(Board board) {
        super(board);
        color = "BLUE";
        fields = new ArrayList<Field>();
    }

    @Override
    void setFields() {
        fields.add(board.getField(4));
        fields.add(board.getField(5));
        fields.add(board.getField(14));
        fields.add(board.getField(15));
        makeFieldsPartOfTile();
    }

    @Override
    void rotateLeft() {
        //rotation doesn't change a thing
    }

    @Override
    void rotateRight() {
        //rotation doesn't change a thing
    }
}
