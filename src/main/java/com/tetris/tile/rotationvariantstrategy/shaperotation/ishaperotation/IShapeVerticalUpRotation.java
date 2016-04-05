package com.tetris.tile.rotationvariantstrategy.shaperotation.ishaperotation;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 31.03.2016.
 */
public class IShapeVerticalUpRotation extends IShapeRotator {
    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getUpperNeighbour() != null && !getSecond(fields).isUpperNeighbourPlacedField();
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getLowerNeighbour() != null && !getSecond(fields).isLowerNeighbourPlacedField();
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        Field lowerNeighbour = getSecond(fields).getLowerNeighbour();
        return lowerNeighbour.getLowerNeighbour() != null && !lowerNeighbour.isLowerNeighbourPlacedField();
    }

    @Override
    public void rotate(List<Field> fields) {
        fields.set(0, getSecond(fields).getUpperNeighbour());
        fields.set(2, getSecond(fields).getLowerNeighbour());
        fields.set(3, fields.get(2).getLowerNeighbour());
    }
}
