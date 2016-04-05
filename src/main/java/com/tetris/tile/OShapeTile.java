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
        fields = new ArrayList<Field>();
        fields.add(board.getField(4));
        fields.add(board.getField(5));
        fields.add(board.getField(14));
        fields.add(board.getField(15));
        makeFieldsPartOfTile();
    }

    @Override
    public void rotate(RotationSide side) {

    }
}
