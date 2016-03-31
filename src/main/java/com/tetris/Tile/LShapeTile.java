package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;

/**
 * Created by User on 06.03.2016.
 */
public class LShapeTile extends Tile {
    public LShapeTile(Board board) {
        super(board);
        color = "PINK";
        int[] iShapePosition = {4, 14, 24, 25};
        setUpFields(iShapePosition);
    }

    @Override
    public void rotate(RotationSide side) {
        ShapeRotation lShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.L);
        if (lShapeRotation != null && lShapeRotation.isPossible(fields)) {
            lShapeRotation.rotate(fields);
        }
    }
}