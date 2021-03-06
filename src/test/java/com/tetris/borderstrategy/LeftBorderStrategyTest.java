package com.tetris.borderstrategy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 19.04.2016.
 */
public class LeftBorderStrategyTest {
    private final int width = 10;
    private final int height = 16;
    private BorderStrategy borderStrategy;
    private Border border;
    private Border nullBorder;

    @Test
    public void shouldReturnBorderIfFieldIsOnLeftBorder() throws Exception {
        //given
        int position = width*7; //random left border position
        int badPosition = 55;
        borderStrategy = new LeftBorderStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.LEFT, border);
        assertNull(nullBorder);
    }
}