package com.tetris.tile.rotationvariantstrategy;

import com.tetris.Field;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by User on 30.03.2016.
 */
public class RotationVariantCreator {
    @SuppressWarnings("unchecked")
    private static final List<RotationVariantStrategy> rotationVariantStrategy =
            Collections.unmodifiableList(Arrays.<RotationVariantStrategy>asList(
                    new HorizontalDownRotationStrategy(),new HorizontalUpRotationStrategy(),
                    new VerticalDownRotationStrategy(), new VerticalUpRotationStrategy()));

    public ShapeRotation getRotation(List<Field> fields, RotationSide side, Shape shape) throws Exception {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getShapeRotation(shape);
            }
        }
        throw new Exception();
    }
}
