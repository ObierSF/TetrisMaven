package com.tetris.Tile;

import com.tetris.Board;
import com.tetris.Tile.RotationVariant.RotationVariantStrategy;
import com.tetris.Tile.RotationVariant.ShapeRotation.SShapeRotation;

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
        for (RotationVariantStrategy strategy : rotationVariantStrategies) {
            if (strategy.validate(fields, side)) {
                return strategy.getSShapeRotation();
            }
        }
        return null;
    }
}