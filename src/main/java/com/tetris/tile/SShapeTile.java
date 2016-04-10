package com.tetris.tile;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class SShapeTile extends Tile {
    public SShapeTile(Board board) {
        super(board);
        color = "GRAY";
        shape = Shape.S;
        makeFieldsPartOfTile();
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(15));
        fields.add(board.getField(25));
    }
}