package com.tetris;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalUpRotationStrategy extends RotationVariantStrategy {
    @Override
    boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && isVertical(fields) && isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && isVertical(fields) && !isUpSideDown(fields);
    }

    @Override
    IShapeRotation getIShapeRotation() {
        return IShapeRotation.HORIZONTALUP;
    }

    @Override
    JShapeRotation getJShapeRotation() {
        return JShapeRotation.HORIZONTALUP;
    }

    @Override
    LShapeRotation getLShapeRotation() {
        return LShapeRotation.HORIZONTALUP;
    }

    @Override
    SShapeRotation getSShapeRotation() {
        return SShapeRotation.HORIZONTALUP;
    }

    @Override
    TShapeRotation getTShapeRotation() {
        return TShapeRotation.HORIZONTALUP;
    }

    @Override
    ZShapeRotation getZShapeRotation() {
        return ZShapeRotation.HORIZONTALUP;
    }
}
