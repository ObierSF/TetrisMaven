package com.tetris;

/**
 * Created by User on 06.03.2016.
 */
public class ZShapeTile extends Tile {
    ZShapeTile(Board board) {
        super(board);
        color = "ORANGE";
        int[] iShapePosition = {5, 14, 15, 24};
        setUpFields(iShapePosition);
    }

    @Override
    void rotate(String side) {
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