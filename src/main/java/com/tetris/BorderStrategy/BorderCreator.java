package com.tetris.borderstrategy;

import com.tetris.Border;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 30.03.2016.
 */
public class BorderCreator {
    @SuppressWarnings("unchecked")
    private static final List<BorderStrategy> borderStrategy =
            Collections.unmodifiableList(Arrays.<BorderStrategy>asList(
                    new LeftTopCornerStrategy(), new RightTopCornerStrategy(), new LeftBottomCornerStrategy(),
                    new RightBottomCornerStrategy(), new TopBorderStrategy(), new LeftBorderStrategy(),
                    new RightBorderStrategy(), new BottomBorderStrategy(), new NonBorderStrategy()));

    public Border getBorder(int width, int height, int position, Border border) {
        for (BorderStrategy strategy : borderStrategy) {
            if (strategy.validate(width, height, position, border)) {
                return strategy.getBorder();
            }
        }
        return null;
    }
}
