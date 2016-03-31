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
public class VerticalDownRotationStrategy extends RotationVariantStrategy {
    private Map<Shape, ShapeRotation> shapeRotationMap;

    public VerticalDownRotationStrategy() {
        shapeRotationMap = new HashMap<Shape, ShapeRotation>();
        shapeRotationMap.put(Shape.I, IShapeRotation.VERTICALDOWN);
        shapeRotationMap.put(Shape.J, JShapeRotation.VERTICALDOWN);
        shapeRotationMap.put(Shape.L, LShapeRotation.VERTICALDOWN);
        shapeRotationMap.put(Shape.S, SShapeRotation.VERTICALDOWN);
        shapeRotationMap.put(Shape.T, TShapeRotation.VERTICALDOWN);
        shapeRotationMap.put(Shape.Z, ZShapeRotation.VERTICALDOWN);
    }

    @Override
    public boolean validate(List<Field> fields, RotationSide side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, RotationSide side) {
        return side.equals(RotationSide.RIGHT) && !isVertical(fields) && isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, RotationSide side) {
        return side.equals(RotationSide.LEFT) && !isVertical(fields) && !isUpSideDown(fields);
    }

    @Override
    public ShapeRotation getShapeRotation(Shape shape) {
        return shapeRotationMap.get(shape);
    }
}
