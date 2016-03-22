package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class LShapeTile extends Tile {
    LShapeTile(Board board) {
        super(board);
        color = "PINK";
        int[] iShapePosition = {4, 14, 24, 25};
        setUpFields(iShapePosition);
    }

    @Override
    void rotate(String side) {
        LShapeRotation lShapeRotation = getRotation(side);
        if (lShapeRotation != null && lShapeRotation.isPossible(fields)) {
            lShapeRotation.rotate(fields);
        }
    }

    private LShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategies) {
            if (strategy.validate(fields, side)) {
                return strategy.getLShapeRotation();
            }
        }
        return null;
    }
}