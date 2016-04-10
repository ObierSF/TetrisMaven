package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.Shape;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalDownRotationStrategy extends RotationVariantStrategy {
    @Override
    public boolean validate(List<Field> fields, RotationSide side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, RotationSide side) {
        return side.equals(RotationSide.RIGHT) && isVertical(fields) && !isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, RotationSide side) {
        return side.equals(RotationSide.LEFT) && isVertical(fields) && isUpSideDown(fields);
    }

    @Override
    public RotationVariant getRotationVariant() {
        return RotationVariant.HORIZONTALDOWN;
    }
}
