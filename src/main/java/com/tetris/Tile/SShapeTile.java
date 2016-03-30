package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.SShapeRotation;

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
    public void rotate(String side) {
        SShapeRotation sShapeRotation = getRotation(side);
        if (sShapeRotation != null && sShapeRotation.isPossible(fields)) {
            sShapeRotation.rotate(fields);
        }
    }

    private SShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getSShapeRotation();
            }
        }
        return null;
    }
}