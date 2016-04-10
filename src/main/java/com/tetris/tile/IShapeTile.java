package com.tetris.tile;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class IShapeTile extends Tile {

    public IShapeTile(Board board) {
        super(board);
        color = "RED";
        shape = Shape.I;
        makeFieldsPartOfTile();
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
        fields.add(board.getField(34));
    }
}