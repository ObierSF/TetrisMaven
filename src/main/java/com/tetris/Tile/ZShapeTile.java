package com.tetris.Tile;

import com.tetris.Board;
import com.tetris.Tile.RotationVariantStrategy.RotationVariantStrategy;
import com.tetris.Tile.RotationVariantStrategy.ShapeRotation.ZShapeRotation;

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
        ZShapeRotation zShapeRotation = getRotation(side);
        if (zShapeRotation != null && zShapeRotation.isPossible(fields)) {
            zShapeRotation.rotate(fields);
        }
    }

    private ZShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategies) {
            if (strategy.validate(fields, side)) {
                return strategy.getZShapeRotation();
            }
        }
        return null;
    }
}