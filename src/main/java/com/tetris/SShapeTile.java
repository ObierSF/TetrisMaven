package com.tetris;

/**
 * Created by User on 06.03.2016.
 */
public class SShapeTile extends Tile {
    SShapeTile(Board board) {
        super(board);
        color = "GRAY";
        int[] iShapePosition = {4, 14, 15, 25};
        setUpFields(iShapePosition);
    }

    @Override
    void rotate(String side) {
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