package com.tetris.tile;

import com.tetris.Board;
import com.tetris.field.Field;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class TShapeTile extends Tile {
    public TShapeTile(Board board) {
        super(board);
        color = Color.YELLOW;
        shape = Shape.T;
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
        fields.add(board.getField(13));
    }
}