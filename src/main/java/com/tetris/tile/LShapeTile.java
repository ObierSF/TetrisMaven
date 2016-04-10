package com.tetris.tile;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class LShapeTile extends Tile {
    public LShapeTile(Board board) {
        super(board);
        color = "PINK";
        shape = Shape.L;
        makeFieldsPartOfTile();
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
        fields.add(board.getField(25));
    }
}