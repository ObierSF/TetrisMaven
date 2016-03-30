package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.shaperotation.LShapeRotation;
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
    public void rotate(String side) {
        LShapeRotation lShapeRotation = getRotation(side);
        if (lShapeRotation != null && lShapeRotation.isPossible(fields)) {
            lShapeRotation.rotate(fields);
        }
    }

    private LShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getLShapeRotation();
            }
        }
        return null;
    }
}