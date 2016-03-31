package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class SShapeTile extends Tile {
    public SShapeTile(Board board) {
        super(board);
        color = "GRAY";
        int[] iShapePosition = {4, 14, 15, 25};
        setUpFields(iShapePosition);
    }

    @Override
    public void rotate(RotationSide side) {
        ShapeRotation sShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.S);
        if (sShapeRotation != null && sShapeRotation.isPossible(fields)) {
            sShapeRotation.rotate(fields);
        }
    }
}