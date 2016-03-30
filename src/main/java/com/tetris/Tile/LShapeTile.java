package com.tetris.tile;

import com.tetris.Board;
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
    public void rotate(String side) {
        ShapeRotation lShapeRotation = getRotation(side);
        if (lShapeRotation != null && lShapeRotation.isPossible(fields)) {
            lShapeRotation.rotate(fields);
        }
    }

    private ShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getShapeRotation("L");
            }
        }
        return null;
    }
}