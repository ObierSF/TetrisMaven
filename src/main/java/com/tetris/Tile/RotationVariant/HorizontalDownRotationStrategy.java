package com.tetris.Tile.RotationVariant;

import com.tetris.*;
import com.tetris.Tile.RotationVariant.ShapeRotation.*;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalDownRotationStrategy extends RotationVariantStrategy {
    @Override
    public boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && isVertical(fields) && !isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && isVertical(fields) && isUpSideDown(fields);
    }

    @Override
    public IShapeRotation getIShapeRotation() {
        return IShapeRotation.HORIZONTALDOWN;
    }

    @Override
    public JShapeRotation getJShapeRotation() {
        return JShapeRotation.HORIZONTALDOWN;
    }

    @Override
    public LShapeRotation getLShapeRotation() {
        return LShapeRotation.HORIZONTALDOWN;
    }

    @Override
    public SShapeRotation getSShapeRotation() {
        return SShapeRotation.HORIZONTALDOWN;
    }

    @Override
    public TShapeRotation getTShapeRotation() {
        return TShapeRotation.HORIZONTALDOWN;
    }

    @Override
    public ZShapeRotation getZShapeRotation() {
        return ZShapeRotation.HORIZONTALDOWN;
    }
}
