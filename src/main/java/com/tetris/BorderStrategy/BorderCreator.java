package com.tetris.borderstrategy;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 30.03.2016.
 */
public class BorderCreator {
    @SuppressWarnings("unchecked")
    @Getter private static final List<BorderStrategy> borderStrategy =
            Collections.unmodifiableList(Arrays.<BorderStrategy>asList(
                    new BottomBorderStrategy(), new LeftBorderStrategy(), new LeftBottomCornerStrategy(),
                    new LeftTopCornerStrategy(), new NonBorderStrategy(), new RightBorderStrategy(),
                    new RightBottomCornerStrategy(), new RightTopCornerStrategy(), new TopBorderStrategy()));
}
