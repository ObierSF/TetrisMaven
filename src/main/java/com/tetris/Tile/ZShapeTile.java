package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class ZShapeTile extends Tile {
    public ZShapeTile(Board board) {
        super(board);
        color = "ORANGE";
        int[] iShapePosition = {5, 14, 15, 24};
        setUpFields(iShapePosition);
    }

    @Override
    public void rotate(String side) {
        ShapeRotation zShapeRotation = getRotation(side);
        if (zShapeRotation != null && zShapeRotation.isPossible(fields)) {
            zShapeRotation.rotate(fields);
        }
    }

    private ShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getShapeRotation("Z");
            }
        }
        return null;
    }
}