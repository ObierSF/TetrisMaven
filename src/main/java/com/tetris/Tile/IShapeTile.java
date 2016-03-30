package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.shaperotation.IShapeRotation;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
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
    public void rotate(String side) {
        ShapeRotation iShapeRotation = getRotation(side);
        if (iShapeRotation != null && iShapeRotation.isPossible(fields)) {
            iShapeRotation.rotate(fields);
        }
    }

    private ShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getShapeRotation("I");
            }
        }
        return null;
    }
}