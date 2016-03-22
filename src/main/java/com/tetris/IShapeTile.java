package com.tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public class IShapeTile extends Tile {

    IShapeTile(Board board) {
        super(board);
        color = "RED";
        int[] iShapePosition = {4, 14, 24, 34};
        setUpFields(iShapePosition);
    }

    @Override
    void rotate(String side) {
        IShapeRotation iShapeRotation = getRotation(side);
        if (iShapeRotation != null && iShapeRotation.isPossible(fields)) {
            iShapeRotation.rotate(fields);
        }
    }

    private IShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategies) {
            if (strategy.validate(fields, side)) {
                return strategy.getIShapeRotation();
            }
        }
        return null;
    }
}