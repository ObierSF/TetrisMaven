package com.tetris;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public class VerticalDownRotationStrategy extends RotationVariantStrategy {
    @Override
    boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && !isVertical(fields) && isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && !isVertical(fields) && !isUpSideDown(fields);
    }

    @Override
    IShapeRotation getIShapeRotation() {
        return IShapeRotation.VERTICALDOWN;
    }

    @Override
    JShapeRotation getJShapeRotation() {
        return JShapeRotation.VERTICALDOWN;
    }

    @Override
    LShapeRotation getLShapeRotation() {
        return LShapeRotation.VERTICALDOWN;
    }

    @Override
    SShapeRotation getSShapeRotation() {
        return SShapeRotation.VERTICALDOWN;
    }

    @Override
    TShapeRotation getTShapeRotation() {
        return TShapeRotation.VERTICALDOWN;
    }

    @Override
    ZShapeRotation getZShapeRotation() {
        return ZShapeRotation.VERTICALDOWN;
    }
}
