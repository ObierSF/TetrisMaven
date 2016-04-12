package com.tetris.tile.rotationstrategy.lshaperotation;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.List;

/**
 * Created by User on 05.04.2016.
 */
public class LShapeVerticalUpRotation extends RotationStrategy {
    @Override
    public boolean validate(Shape shape, RotationVariant rotationVariant) {
        return shape.equals(Shape.L) && rotationVariant.equals(RotationVariant.VERTICALUP);
    }

    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.UPPER) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.UPPER);
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.LOWER) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.RIGHT);
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        Field lowerNeighbour = getSecond(fields).getNeighbour(Neighbour.LOWER);
        return lowerNeighbour.getNeighbour(Neighbour.RIGHT) != null && !lowerNeighbour.isNeighbourPlacedField(Neighbour.RIGHT);
    }

    @Override
    public void rotate(List<Field> fields) {
        fields.set(0, getSecond(fields).getNeighbour(Neighbour.UPPER));
        fields.set(2, getSecond(fields).getNeighbour(Neighbour.LOWER));
        fields.set(3, fields.get(2).getNeighbour(Neighbour.RIGHT));
    }
}
