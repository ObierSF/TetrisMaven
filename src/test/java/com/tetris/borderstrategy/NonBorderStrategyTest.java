package com.tetris.borderstrategy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 19.04.2016.
 */
public class NonBorderStrategyTest {
    private final int width = 10;
    private final int height = 16;
    private BorderStrategy borderStrategy;
    private Border border;
    private Border nullBorder;

    @Test
    public void shouldReturnBorderIfFieldIsNotOnBorder() throws Exception {
        //given random non border position
        int position = width*14+8;
        borderStrategy = new NonBorderStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.NONBORDER, border);
    }
}