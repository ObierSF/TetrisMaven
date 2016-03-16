package com.tetris;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 09.03.2016.
 */
public class BorderStrategyTest {
    final int height = 16;
    final int width = 10;
    BorderStrategy borderStrategy;
    Border border;
    Border nullBorder;

    @Test
    public void shouldReturnBorderIfFieldIsInLeftTopCorner() throws Exception {
        //given
        int position = 0; //left top position
        int badPosition = 55;
        borderStrategy = new LeftTopCornerStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.LEFTTOPCORNER, border);
        assertNull(nullBorder);
    }

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

    @Test
    public void shouldReturnBorderIfFieldIsInLeftBottomCorner() throws Exception {
        //given
        int position = height*width-width; //left bottom position
        int badPosition = 55;
        borderStrategy = new LeftBottomCornerStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.LEFTBOTTOMCORNER, border);
        assertNull(nullBorder);
    }

    @Test
    public void shouldReturnBorderIfFieldIsInRightBottomCorner() throws Exception {
        //given
        int position = height*width-1; //right bottom position
        int badPosition = 55;
        borderStrategy = new RightBottomCornerStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.RIGHTBOTTOMCORNER, border);
        assertNull(nullBorder);
    }

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

    @Test
    public void shouldReturnBorderIfFieldIsOnRightBorder() throws Exception {
        //given
        int position = width*12-1; //random right border position
        int badPosition = 55;
        borderStrategy = new RightBorderStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.RIGHT, border);
        assertNull(nullBorder);
    }

    @Test
    public void shouldReturnBorderIfFieldIsOnTopBorder() throws Exception {
        //given
        int position = 1; //random top border position
        int badPosition = 55;
        borderStrategy = new TopBorderStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.TOP, border);
        assertNull(nullBorder);
    }

    @Test
    public void shouldReturnBorderIfFieldIsOnBottomBorder() throws Exception {
        //given
        int position = height*width-2; //random bottom border position
        int badPosition = 55;
        borderStrategy = new BottomBorderStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.BOTTOM, border);
        assertNull(nullBorder);
    }

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