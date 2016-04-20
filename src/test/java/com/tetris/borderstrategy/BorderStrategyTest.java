package com.tetris.borderstrategy;

import com.tetris.borderstrategy.Border;
import com.tetris.borderstrategy.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by User on 09.03.2016.
 */
public class BorderStrategyTest {
    final int height = 16;
    final int width = 10;
    Border border;
    BorderCreator borderCreator;

    @Before
    public void setUp() throws Exception {
        borderCreator = new BorderCreator();
        border = null;
    }

    @Test
    public void shouldReturnBorderIfFieldIsInLeftTopCorner() throws Exception {
        //given
        int leftTopPosition = 0;
        //when
        border = borderCreator.getBorder(width, height, leftTopPosition, border);
        //then
        assertEquals(Border.LEFTTOPCORNER, border);
    }

    @Test
    public void shouldReturnBorderIfFieldIsInLeftBottomCorner() throws Exception {
        //given
        int leftBottomPosition = height*width-width;
        //when
        border = borderCreator.getBorder(width, height, leftBottomPosition, border);
        //then
        assertEquals(Border.LEFTBOTTOMCORNER, border);
    }

    @Test
    public void shouldReturnBorderIfFieldIsInRightBottomCorner() throws Exception {
        //given
        int rightBottomPosition = height*width-1;
        //when
        border = borderCreator.getBorder(width, height, rightBottomPosition, border);
        //then
        assertEquals(Border.RIGHTBOTTOMCORNER, border);
    }

    @Test
    public void shouldReturnBorderIfFieldIsOnLeftBorder() throws Exception {
        //given
        int pseudoRandomLeftBorderPosition = width*7;
        //when
        border = borderCreator.getBorder(width, height, pseudoRandomLeftBorderPosition, border);
        //then
        assertEquals(Border.LEFT, border);
    }

    @Test
    public void shouldReturnBorderIfFieldIsOnRightBorder() throws Exception {
        //given
        int pseudoRandomRightBorderPosition = width*12-1;
        //when
        border = borderCreator.getBorder(width, height, pseudoRandomRightBorderPosition, border);
        //then
        assertEquals(Border.RIGHT, border);
    }

    @Test
    public void shouldReturnBorderIfFieldIsNotOnBorder() throws Exception {
        //given
        int nonBorderPosition = width*14+8;
        //when
        border = borderCreator.getBorder(width, height, nonBorderPosition, border);
        //then
        assertEquals(Border.NONBORDER, border);
    }
}