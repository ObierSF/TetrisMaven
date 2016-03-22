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
        return Math.abs(fields.get(0).getPosition() - fields.get(1).getPosition()) == 10;
    }

    boolean isUpSideDown(List<Field> fields) {
        return fields.get(0).getPosition() > fields.get(1).getPosition();
    }
}
