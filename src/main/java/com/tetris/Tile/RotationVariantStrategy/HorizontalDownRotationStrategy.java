package com.tetris.tile.rotationvariantstrategy;

import com.tetris.*;
import com.tetris.tile.rotationvariantstrategy.shaperotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalDownRotationStrategy extends RotationVariantStrategy {
    private Map<String, ShapeRotation> shapeRotationMap;

    public HorizontalDownRotationStrategy() {
        shapeRotationMap = new HashMap<String, ShapeRotation>();
        shapeRotationMap.put("I", IShapeRotation.HORIZONTALDOWN);
        shapeRotationMap.put("J", JShapeRotation.HORIZONTALDOWN);
        shapeRotationMap.put("L", LShapeRotation.HORIZONTALDOWN);
        shapeRotationMap.put("S", SShapeRotation.HORIZONTALDOWN);
        shapeRotationMap.put("T", TShapeRotation.HORIZONTALDOWN);
        shapeRotationMap.put("Z", ZShapeRotation.HORIZONTALDOWN);
    }

    @Override
    public boolean validate(List<Field> fields, String side) {
        return isLeftRotation(fields, side) || isRightRotation(fields, side);
    }

    private boolean isRightRotation(List<Field> fields, String side) {
        return side.equals("right") && isVertical(fields) && !isUpSideDown(fields);
    }

    private boolean isLeftRotation(List<Field> fields, String side) {
        return side.equals("left") && isVertical(fields) && isUpSideDown(fields);
    }

    @Override
    public ShapeRotation getShapeRotation(String shape) {
        return shapeRotationMap.get(shape);
    }
}
