package com.tetris;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
abstract class RotationVariantStrategy {
    abstract boolean validate(List<Field> fields, String side);
    abstract IShapeRotation getIShapeRotation();
    abstract JShapeRotation getJShapeRotation();
    abstract LShapeRotation getLShapeRotation();
    abstract SShapeRotation getSShapeRotation();
    abstract TShapeRotation getTShapeRotation();
    abstract ZShapeRotation getZShapeRotation();

    boolean isVertical(List<Field> fields) {
        int width = 10;
        int higherFieldPosition = fields.get(0).getPosition();
        int lowerFieldPosition = fields.get(1).getPosition();
        return Math.abs(higherFieldPosition - lowerFieldPosition) == width;
    }

    boolean isUpSideDown(List<Field> fields) {
        int higherFieldPosition = fields.get(0).getPosition();
        int lowerFieldPosition = fields.get(1).getPosition();
        return higherFieldPosition > lowerFieldPosition;
    }
}
