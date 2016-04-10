package com.tetris.tile;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class JShapeTile extends Tile {

    public JShapeTile(Board board) {
        super(board);
        color = "GREEN";
        shape = Shape.J;
        makeFieldsPartOfTile();
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(5));
        fields.add(board.getField(15));
        fields.add(board.getField(25));
        fields.add(board.getField(24));
    }
}
