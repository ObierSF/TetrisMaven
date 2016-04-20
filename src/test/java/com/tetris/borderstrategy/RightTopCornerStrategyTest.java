package com.tetris.borderstrategy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 19.04.2016.
 */
public class RightTopCornerStrategyTest {
    private final int width = 10;
    private final int height = 16;
    private BorderStrategy borderStrategy;
    private Border border;
    private Border nullBorder;

    @Test
    public void shouldReturnBorderIfFieldIsInRightTopCorner() throws Exception {
        //given
        int position = width - 1; //right top position
        int badPosition = 55;
        borderStrategy = new RightTopCornerStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.RIGHTTOPCORNER, border);
        assertNull(nullBorder);
    }
}