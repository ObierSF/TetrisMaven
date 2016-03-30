package com.tetris.tile.rotationvariantstrategy;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 30.03.2016.
 */
public class RotationVariantCreator {
    @SuppressWarnings("unchecked")
    @Getter private static final List<RotationVariantStrategy> rotationVariantStrategy =
            Collections.unmodifiableList(Arrays.<RotationVariantStrategy>asList(
                    new HorizontalDownRotationStrategy(),new HorizontalUpRotationStrategy(),
                    new VerticalDownRotationStrategy(), new VerticalUpRotationStrategy()));
}
