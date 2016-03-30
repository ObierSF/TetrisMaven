package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.rotationvariantstrategy.shaperotation.*;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalUpRotationStrategy extends RotationVariantStrategy {
    @Override
    public boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && isVertical(fields) && isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && isVertical(fields) && !isUpSideDown(fields);
    }

    @Override
    public IShapeRotation getIShapeRotation() {
        return IShapeRotation.HORIZONTALUP;
    }

    @Override
    public JShapeRotation getJShapeRotation() {
        return JShapeRotation.HORIZONTALUP;
    }

    @Override
    public LShapeRotation getLShapeRotation() {
        return LShapeRotation.HORIZONTALUP;
    }

    @Override
    public SShapeRotation getSShapeRotation() {
        return SShapeRotation.HORIZONTALUP;
    }

    @Override
    public TShapeRotation getTShapeRotation() {
        return TShapeRotation.HORIZONTALUP;
    }

    @Override
    public ZShapeRotation getZShapeRotation() {
        return ZShapeRotation.HORIZONTALUP;
    }
}
