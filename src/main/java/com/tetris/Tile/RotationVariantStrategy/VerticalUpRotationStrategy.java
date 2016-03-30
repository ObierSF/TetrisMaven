package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.rotationvariantstrategy.shaperotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 22.03.2016.
 */
public class VerticalUpRotationStrategy extends RotationVariantStrategy {
    private Map<String, ShapeRotation> shapeRotationMap;

    public VerticalUpRotationStrategy() {
        shapeRotationMap = new HashMap<String, ShapeRotation>();
        shapeRotationMap.put("I", IShapeRotation.VERTICALUP);
        shapeRotationMap.put("J", JShapeRotation.VERTICALUP);
        shapeRotationMap.put("L", LShapeRotation.VERTICALUP);
        shapeRotationMap.put("S", SShapeRotation.VERTICALUP);
        shapeRotationMap.put("T", TShapeRotation.VERTICALUP);
        shapeRotationMap.put("Z", ZShapeRotation.VERTICALUP);
    }

    @Override
    public boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && !isVertical(fields) && !isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && !isVertical(fields) && isUpSideDown(fields);
    }

    @Override
    public ShapeRotation getShapeRotation(String shape) {
        return shapeRotationMap.get(shape);
    }
}
