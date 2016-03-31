package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationvariantstrategy.shaperotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 22.03.2016.
 */
public class VerticalUpRotationStrategy extends RotationVariantStrategy {
    private Map<Shape, ShapeRotation> shapeRotationMap;

    public VerticalUpRotationStrategy() {
        shapeRotationMap = new HashMap<Shape, ShapeRotation>();
        shapeRotationMap.put(Shape.I, IShapeRotation.VERTICALUP);
        shapeRotationMap.put(Shape.J, JShapeRotation.VERTICALUP);
        shapeRotationMap.put(Shape.L, LShapeRotation.VERTICALUP);
        shapeRotationMap.put(Shape.S, SShapeRotation.VERTICALUP);
        shapeRotationMap.put(Shape.T, TShapeRotation.VERTICALUP);
        shapeRotationMap.put(Shape.Z, ZShapeRotation.VERTICALUP);
    }

    @Override
    public boolean validate(List<Field> fields, RotationSide side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, RotationSide side) {
        return side.equals(RotationSide.RIGHT) && !isVertical(fields) && !isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, RotationSide side) {
        return side.equals(RotationSide.LEFT) && !isVertical(fields) && isUpSideDown(fields);
    }

    @Override
    public ShapeRotation getShapeRotation(Shape shape) {
        return shapeRotationMap.get(shape);
    }
}
