package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.rotationvariantstrategy.shaperotation.*;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public class VerticalUpRotationStrategy extends RotationVariantStrategy {
    @Override
    public boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && !isVertical(fields) && !isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && !isVertical(fields) && isUpSideDown(fields);
    }

    @Override
    public IShapeRotation getIShapeRotation() {
        return IShapeRotation.VERTICALUP;
    }

    @Override
    public JShapeRotation getJShapeRotation() {
        return JShapeRotation.VERTICALUP;
    }

    @Override
    public LShapeRotation getLShapeRotation() {
        return LShapeRotation.VERTICALUP;
    }

    @Override
    public SShapeRotation getSShapeRotation() {
        return SShapeRotation.VERTICALUP;
    }

    @Override
    public TShapeRotation getTShapeRotation() {
        return TShapeRotation.VERTICALUP;
    }

    @Override
    public ZShapeRotation getZShapeRotation() {
        return ZShapeRotation.VERTICALUP;
    }
}
