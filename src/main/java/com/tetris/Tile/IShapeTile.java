package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class IShapeTile extends Tile {

    public IShapeTile(Board board) {
        super(board);
        color = "RED";
        int[] iShapePosition = {4, 14, 24, 34};
        setUpFields(iShapePosition);
    }

    @Override
    public void rotate(RotationSide side) {
        ShapeRotation iShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.I);
        if (iShapeRotation != null && iShapeRotation.isPossible(fields)) {
            iShapeRotation.rotate(fields);
        }
    }
}