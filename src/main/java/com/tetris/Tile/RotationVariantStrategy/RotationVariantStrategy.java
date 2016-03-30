package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.rotationvariantstrategy.shaperotation.*;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public abstract class RotationVariantStrategy {
    public abstract boolean validate(List<Field> fields, String side);
    public abstract IShapeRotation getIShapeRotation();
    public abstract JShapeRotation getJShapeRotation();
    public abstract LShapeRotation getLShapeRotation();
    public abstract SShapeRotation getSShapeRotation();
    public abstract TShapeRotation getTShapeRotation();
    public abstract ZShapeRotation getZShapeRotation();

    boolean isVertical(List<Field> fields) {
        int width = 10;
        int higherFieldPosition = fields.get(0).getPosition();
        int lowerFieldPosition = fields.get(1).getPosition();
        return Math.abs(higherFieldPosition - lowerFieldPosition) == width;
    }

    boolean isUpSideDown(List<Field> fields) {
        int higherFieldPosition = fields.get(0).getPosition();
        int lowerFieldPosition = fields.get(1).getPosition();
        return higherFieldPosition > lowerFieldPosition;
    }
}
