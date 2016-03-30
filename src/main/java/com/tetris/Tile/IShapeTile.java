package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.shaperotation.IShapeRotation;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;

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
        IShapeRotation iShapeRotation = getRotation(side);
        if (iShapeRotation != null && iShapeRotation.isPossible(fields)) {
            iShapeRotation.rotate(fields);
        }
    }

    private IShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getIShapeRotation();
            }
        }
        return null;
    }
}