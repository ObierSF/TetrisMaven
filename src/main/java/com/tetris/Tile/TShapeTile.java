package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class TShapeTile extends Tile {
    public TShapeTile(Board board) {
        super(board);
        color = "YELLOW";
        int[] iShapePosition = {4, 14, 24, 13};
        setUpFields(iShapePosition);
    }

    @Override
    public void rotate(RotationSide side) {
        ShapeRotation tShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.T);
        if (tShapeRotation != null && tShapeRotation.isPossible(fields)) {
            tShapeRotation.rotate(fields);
        }
    }
}