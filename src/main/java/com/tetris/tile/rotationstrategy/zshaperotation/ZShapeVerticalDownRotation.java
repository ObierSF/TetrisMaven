package com.tetris.tile.rotationstrategy.zshaperotation;

import com.tetris.Field;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.List;

/**
 * Created by User on 05.04.2016.
 */
public class ZShapeVerticalDownRotation extends RotationStrategy {
    @Override
    public boolean validate(Shape shape, RotationVariant rotationVariant) {
        return shape.equals(Shape.Z) && rotationVariant.equals(RotationVariant.VERTICALDOWN);
    }

    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getLowerNeighbour() != null && !getSecond(fields).isLowerNeighbourPlacedField();
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getRightNeighbour() != null && !getSecond(fields).isRightNeighbourPlacedField();
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        Field rightNeighbour = getSecond(fields).getRightNeighbour();
        return rightNeighbour.getUpperNeighbour() != null && !rightNeighbour.isUpperNeighbourPlacedField();
    }

    @Override
    public void rotate(List<Field> fields) {
        fields.set(0, getSecond(fields).getLowerNeighbour());
        fields.set(2, getSecond(fields).getRightNeighbour());
        fields.set(3, fields.get(2).getUpperNeighbour());
    }
}
