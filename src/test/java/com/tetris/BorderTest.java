package com.tetris;

import com.tetris.borderstrategy.Border;
import com.tetris.field.SurroundingFields;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 17.03.2016.
 */
public class BorderTest {
    final int width = 10;
    final int height = 16;
    Board board;

    @Before
    public void setUp() throws Exception {
        int width = 10;
        int height = 16;
        board = new Board(width * height);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForLeftBorder() throws Exception {
        //given
        int pseudoRandomNumber = 7;
        int randomLeftBorderPosition = width * pseudoRandomNumber;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.LEFT.determineTheSurroundingFields(board, randomLeftBorderPosition);
        //then
        assertNull(surroundingFields.left);
        assertEquals(board.getField(randomLeftBorderPosition - width), surroundingFields.upper);
        assertEquals(board.getField(randomLeftBorderPosition + 1), surroundingFields.right);
        assertEquals(board.getField(randomLeftBorderPosition + width), surroundingFields.lower);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForRightBorder() throws Exception {
        //given
        int pseudoRandomNumber = 12;
        int randomRightBorderPosition = width * pseudoRandomNumber - 1;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.RIGHT.determineTheSurroundingFields(board, randomRightBorderPosition);
        //then
        assertEquals(board.getField(randomRightBorderPosition - width), surroundingFields.upper);
        assertNull(surroundingFields.right);
        assertEquals(board.getField(randomRightBorderPosition + width), surroundingFields.lower);
        assertEquals(board.getField(randomRightBorderPosition - 1), surroundingFields.left);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForTopBorder() throws Exception {
        //given
        int pseudoRandomNumber = 6;
        int randomTopBorderPosition = pseudoRandomNumber;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.TOP.determineTheSurroundingFields(board, randomTopBorderPosition);
        //then
        assertNull(surroundingFields.upper);
        assertEquals(board.getField(randomTopBorderPosition + 1), surroundingFields.right);
        assertEquals(board.getField(randomTopBorderPosition + width), surroundingFields.lower);
        assertEquals(board.getField(randomTopBorderPosition - 1), surroundingFields.left);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForBottomBorder() throws Exception {
        //given
        int pseudoRandomNumber = 2;
        int randomBottomBorderPosition = height * width - pseudoRandomNumber;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.BOTTOM.determineTheSurroundingFields(board, randomBottomBorderPosition);
        //then
        assertEquals(board.getField(randomBottomBorderPosition - width), surroundingFields.upper);
        assertEquals(board.getField(randomBottomBorderPosition + 1), surroundingFields.right);
        assertNull(surroundingFields.lower);
        assertEquals(board.getField(randomBottomBorderPosition - 1), surroundingFields.left);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForLeftTopCorner() throws Exception {
        //given
        int leftTopPosition = 0;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.LEFTTOPCORNER.determineTheSurroundingFields(board, leftTopPosition);
        //then
        assertNull(surroundingFields.upper);
        assertEquals(board.getField(leftTopPosition + 1), surroundingFields.right);
        assertEquals(board.getField(leftTopPosition + width), surroundingFields.lower);
        assertNull(surroundingFields.left);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForRightTopCorner() throws Exception {
        //given
        int rightTopPosition = width - 1;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.RIGHTTOPCORNER.determineTheSurroundingFields(board, rightTopPosition);
        //then
        assertNull(surroundingFields.upper);
        assertNull(surroundingFields.right);
        assertEquals(board.getField(rightTopPosition + width), surroundingFields.lower);
        assertEquals(board.getField(rightTopPosition - 1), surroundingFields.left);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForLeftBottomCorner() throws Exception {
        //given
        int leftBottomPosition = height*width-width;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.LEFTBOTTOMCORNER.determineTheSurroundingFields(board, leftBottomPosition);
        //then
        assertEquals(board.getField(leftBottomPosition - width), surroundingFields.upper);
        assertEquals(board.getField(leftBottomPosition + 1), surroundingFields.right);
        assertNull(surroundingFields.lower);
        assertNull(surroundingFields.left);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForRightBottomCorner() throws Exception {
        //given
        int rightBottomPosition = height*width-1;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.RIGHTBOTTOMCORNER.determineTheSurroundingFields(board, rightBottomPosition);
        //then
        assertEquals(board.getField(rightBottomPosition - width), surroundingFields.upper);
        assertNull(surroundingFields.right);
        assertNull(surroundingFields.lower);
        assertEquals(board.getField(rightBottomPosition - 1), surroundingFields.left);
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForNonBorder() throws Exception {
        //given
        int pseudoRandomNumber = 14;
        int secondPseudoRandomNumber = 8;
        int randomNonBorderPosition = width * pseudoRandomNumber + secondPseudoRandomNumber;
        SurroundingFields surroundingFields;
        //when
        surroundingFields = Border.NONBORDER.determineTheSurroundingFields(board, randomNonBorderPosition);
        //then
        assertEquals(board.getField(randomNonBorderPosition - width), surroundingFields.upper);
        assertEquals(board.getField(randomNonBorderPosition + 1), surroundingFields.right);
        assertEquals(board.getField(randomNonBorderPosition + width), surroundingFields.lower);
        assertEquals(board.getField(randomNonBorderPosition - 1), surroundingFields.left);
    }
}