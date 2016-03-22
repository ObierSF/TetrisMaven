package com.tetris;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public class VerticalUpRotationStrategy extends RotationVariantStrategy {
    @Override
    boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && !isVertical(fields) && !isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && !isVertical(fields) && isUpSideDown(fields);
    }

    @Override
    IShapeRotation getIShapeRotation() {
        return IShapeRotation.VERTICALUP;
    }

    @Override
    JShapeRotation getJShapeRotation() {
        return JShapeRotation.VERTICALUP;
    }

    @Override
    LShapeRotation getLShapeRotation() {
        return LShapeRotation.VERTICALUP;
    }

    @Override
    SShapeRotation getSShapeRotation() {
        return SShapeRotation.VERTICALUP;
    }

    @Override
    TShapeRotation getTShapeRotation() {
        return TShapeRotation.VERTICALUP;
    }

    @Override
    ZShapeRotation getZShapeRotation() {
        return ZShapeRotation.VERTICALUP;
    }
}
