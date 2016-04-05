package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationvariantstrategy.shaperotation.*;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ishaperotation.IShapeRotation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalUpRotationStrategy extends RotationVariantStrategy {
    private Map<Shape, ShapeRotation> shapeRotationMap;

    public HorizontalUpRotationStrategy() {
        shapeRotationMap = new HashMap<Shape, ShapeRotation>();
        shapeRotationMap.put(Shape.I, IShapeRotation.HORIZONTALUP);
        shapeRotationMap.put(Shape.J, JShapeRotation.HORIZONTALUP);
        shapeRotationMap.put(Shape.L, LShapeRotation.HORIZONTALUP);
        shapeRotationMap.put(Shape.S, SShapeRotation.HORIZONTALUP);
        shapeRotationMap.put(Shape.T, TShapeRotation.HORIZONTALUP);
        shapeRotationMap.put(Shape.Z, ZShapeRotation.HORIZONTALUP);
    }

    @Override
    public boolean validate(List<Field> fields, RotationSide side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, RotationSide side) {
        return side.equals(RotationSide.RIGHT) && isVertical(fields) && isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, RotationSide side) {
        return side.equals(RotationSide.LEFT) && isVertical(fields) && !isUpSideDown(fields);
    }

    @Override
    public ShapeRotation getShapeRotation(Shape shape) {
        return shapeRotationMap.get(shape);
    }
}
