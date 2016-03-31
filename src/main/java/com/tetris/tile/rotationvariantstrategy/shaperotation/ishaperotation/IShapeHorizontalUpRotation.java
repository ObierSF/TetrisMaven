package com.tetris.tile.rotationvariantstrategy.shaperotation.ishaperotation;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 31.03.2016.
 */
public class IShapeHorizontalUpRotation extends IShapeRotator {
    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getLeftNeighbour() != null && !getSecond(fields).isLeftNeighbourPlacedField();
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getRightNeighbour() != null && !getSecond(fields).isRightNeighbourPlacedField();
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        Field rightNeighbour = getSecond(fields).getRightNeighbour();
        return rightNeighbour.getRightNeighbour() != null && !rightNeighbour.isRightNeighbourPlacedField();
    }

    @Override
    public void rotate(List<Field> fields) {
        fields.set(0, getSecond(fields).getLeftNeighbour());
        fields.set(2, getSecond(fields).getRightNeighbour());
        fields.set(3, fields.get(2).getRightNeighbour());
    }
}
