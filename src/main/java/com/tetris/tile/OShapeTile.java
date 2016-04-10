package com.tetris.tile;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.RotationSide;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class OShapeTile extends Tile {
    public OShapeTile(Board board) {
        super(board);
        color = "BLUE";
        shape = Shape.O;
        makeFieldsPartOfTile();
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(4));
        fields.add(board.getField(5));
        fields.add(board.getField(14));
        fields.add(board.getField(15));
    }
}
