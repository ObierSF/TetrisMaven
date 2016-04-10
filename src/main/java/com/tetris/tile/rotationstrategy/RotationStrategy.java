package com.tetris.tile.rotationstrategy;

import com.tetris.Field;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.List;

/**
 * Created by User on 05.04.2016.
 */
public abstract class RotationStrategy {
    public abstract boolean validate(Shape shape, RotationVariant rotationVariant);
    protected abstract boolean isFirstPositionAvailable(List<Field> fields);
    protected abstract boolean isThrirdPositionAvailable(List<Field> fields);
    protected abstract boolean isForthPositionAvailable(List<Field> fields);
    public abstract void rotate(List<Field> fields);

    public boolean isPossible(List<Field> fields) {
        return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
    }

    protected Field getSecond(List<Field> fields) {
        return fields.get(1);
    }
}
