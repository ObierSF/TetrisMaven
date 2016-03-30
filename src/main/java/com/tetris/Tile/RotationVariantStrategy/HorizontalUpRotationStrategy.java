package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.rotationvariantstrategy.shaperotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalUpRotationStrategy extends RotationVariantStrategy {
    private Map<String, ShapeRotation> shapeRotationMap;

    public HorizontalUpRotationStrategy() {
        shapeRotationMap = new HashMap<String, ShapeRotation>();
        shapeRotationMap.put("I", IShapeRotation.HORIZONTALUP);
        shapeRotationMap.put("J", JShapeRotation.HORIZONTALUP);
        shapeRotationMap.put("L", LShapeRotation.HORIZONTALUP);
        shapeRotationMap.put("S", SShapeRotation.HORIZONTALUP);
        shapeRotationMap.put("T", TShapeRotation.HORIZONTALUP);
        shapeRotationMap.put("Z", ZShapeRotation.HORIZONTALUP);
    }

    @Override
    public boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && isVertical(fields) && isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && isVertical(fields) && !isUpSideDown(fields);
    }

    @Override
    public ShapeRotation getShapeRotation(String shape) {
        return shapeRotationMap.get(shape);
    }
}
