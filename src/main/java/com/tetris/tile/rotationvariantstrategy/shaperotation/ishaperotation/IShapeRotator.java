package com.tetris.tile.rotationvariantstrategy.shaperotation.ishaperotation;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 31.03.2016.
 */
public abstract class IShapeRotator {
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
