package com.tetris.field;

import com.tetris.Board;
import com.tetris.borderstrategy.Border;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

import static org.junit.Assert.*;

/**
 * Created by User on 09.03.2016.
 */
public class FieldTest {
    private final int width = 10;
    private final int height = 16;
    private Field field;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(width * height);
        //given
        int pseudoRandomNumber = 4;
        field = board.getField(pseudoRandomNumber);
    }

    @Test
    public void columnShouldFall() throws Exception {
        //given
        Color pseudoRandomColor = Color.BLUE;
        int[] columnPositions = {50, 40, 30, 20};
        for (int columnPosition : columnPositions) {
            board.getField(columnPosition).placeField(pseudoRandomColor);
        }
        //when
        board.getField(columnPositions[0]).columnFall();
        //then
        assertTrue(board.getField(columnPositions[3]).isEmpty());
        for (int columnPosition : columnPositions) {
            assertTrue(board.getField(columnPosition+width).isPlacedField());
        }
    }

    @Test
    public void shouldReturnTrueIfFallIsPossible() throws Exception {
        //given
        int fieldBelowPosition = 14;
        Color pseudoRandomColor = Color.BLUE;
        //at first
        assertTrue(field.isFallPossible());
        //when
        board.getField(fieldBelowPosition).placeField(pseudoRandomColor);
        //then
        assertFalse(field.isFallPossible());
    }

    @Test
    public void fieldShouldFall() throws Exception {
        //given
        int afterFallPosition = 14;
        Field newField = board.getField(afterFallPosition);
        //when
        field.placeField(Color.BLACK);
        field.fall();
        //then
        assertTrue(field.isEmpty());
        assertTrue(newField.isPlacedField());
    }

    @Test
    public void shouldReturnTrueAfterFieldIsPlaced() throws Exception {
        //given
        Color pseudoRandomColor = Color.BLUE;
        //when
        field.placeField(pseudoRandomColor);
        //then
        assertTrue(field.isPlacedField());
        assertFalse(field.isPartOfTile());
        assertFalse(field.isEmpty());
    }

    @Test
    public void shouldReturnTrueAfterFieldIsMadePartOfTile() throws Exception {
        //given
        Color pseudoRandomColor = Color.RED;
        //when
        field.makePartOfTile(pseudoRandomColor);
        //then
        assertTrue(field.isPartOfTile());
        assertEquals(field.getColor(), pseudoRandomColor);
        assertFalse(field.isPlacedField());
        assertFalse(field.isEmpty());
    }

    @Test
    public void shouldReturnTrueAfterFieldIsEmptied() throws Exception {
        //when
        field.empty();
        //then
        assertTrue(field.isEmpty());
        assertFalse(field.isPartOfTile());
        assertFalse(field.isPlacedField());
    }

    @Test
    public void shouldReturnLeftBorder() throws Exception {
        //given
        int pseudoRandomNumber = 7;
        int randomLeftBorderPosition = width * pseudoRandomNumber;
        //when
        field = board.getField(randomLeftBorderPosition);
        //then
        assertEquals(Border.LEFT, field.getBorder());
    }

    @Test
    public void shouldReturnRightBorder() throws Exception {
        //given
        int pseudoRandomNumber = 12;
        int randomRightBorderPosition = width * pseudoRandomNumber - 1;
        //when
        field = board.getField(randomRightBorderPosition);
        //then
        assertEquals(Border.RIGHT, field.getBorder());
    }
    @Test
    public void shouldReturnTopBorder() throws Exception {
        //given
        int pseudoRandomNumber = 6;
        int randomTopBorderPosition = pseudoRandomNumber;
        //when
        field = board.getField(randomTopBorderPosition);
        //then
        assertEquals(Border.TOP, field.getBorder());
    }

    @Test
    public void shouldReturnBottomBorder() throws Exception {
        //given
        int pseudoRandomNumber = 2;
        int randomBottomBorderPosition = height * width - pseudoRandomNumber;
        //when
        field = board.getField(randomBottomBorderPosition);
        //then
        assertEquals(Border.BOTTOM, field.getBorder());
    }

    @Test
    public void shouldReturnLeftTopCorner() throws Exception {
        //given
        int leftTopPosition = 0;
        //when
        field = board.getField(leftTopPosition);
        //then
        assertEquals(Border.LEFTTOPCORNER, field.getBorder());
    }

    @Test
    public void shouldReturnRightTopCorner() throws Exception {
        //given
        int rightTopPosition = width - 1;
        //when
        field = board.getField(rightTopPosition);
        //then
        assertEquals(Border.RIGHTTOPCORNER, field.getBorder());
    }

    @Test
    public void shouldReturnLeftBottomCorner() throws Exception {
        //given
        int leftBottomPosition = height*width-width;
        //when
        field = board.getField(leftBottomPosition);
        //then
        assertEquals(Border.LEFTBOTTOMCORNER, field.getBorder());
    }

    @Test
    public void shouldReturnRightBottomCorner() throws Exception {
        //given
        int rightBottomPosition = height*width-1;
        //when
        field = board.getField(rightBottomPosition);
        //then
        assertEquals(Border.RIGHTBOTTOMCORNER, field.getBorder());
    }

    @Test
    public void shouldReturnNonBorder() throws Exception {
        //given
        int pseudoRandomNumber = 14;
        int secondPseudoRandomNumber = 8;
        int randomNonBorderPosition = width * pseudoRandomNumber + secondPseudoRandomNumber;
        //when
        field = board.getField(randomNonBorderPosition);
        //then
        assertEquals(Border.NONBORDER, field.getBorder());
    }

    @Test
    public void shouldReturnProperSurroundingFieldsForLeftBorder() throws Exception {
        //given
        int pseudoRandomNumber = 7;
        int randomLeftBorderPosition = width * pseudoRandomNumber;
        SurroundingFields surroundingFields;
        //when
        field = board.getField(randomLeftBorderPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, randomLeftBorderPosition));
        surroundingFields = field.getSurroundingFields();
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
        field = board.getField(randomRightBorderPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, randomRightBorderPosition));
        surroundingFields = field.getSurroundingFields();
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
        field = board.getField(randomTopBorderPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, randomTopBorderPosition));
        surroundingFields = field.getSurroundingFields();
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
        field = board.getField(randomBottomBorderPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, randomBottomBorderPosition));
        surroundingFields = field.getSurroundingFields();
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
        field = board.getField(leftTopPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, leftTopPosition));
        surroundingFields = field.getSurroundingFields();
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
        field = board.getField(rightTopPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, rightTopPosition));
        surroundingFields = field.getSurroundingFields();
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
        field = board.getField(leftBottomPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, leftBottomPosition));
        surroundingFields = field.getSurroundingFields();
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
        field = board.getField(rightBottomPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, rightBottomPosition));
        surroundingFields = field.getSurroundingFields();
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
        field = board.getField(randomNonBorderPosition);
        field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(board, randomNonBorderPosition));
        surroundingFields = field.getSurroundingFields();
        //then
        assertEquals(board.getField(randomNonBorderPosition - width), surroundingFields.upper);
        assertEquals(board.getField(randomNonBorderPosition + 1), surroundingFields.right);
        assertEquals(board.getField(randomNonBorderPosition + width), surroundingFields.lower);
        assertEquals(board.getField(randomNonBorderPosition - 1), surroundingFields.left);
    }

    @Test
    public void shouldReturnTrueIfRowIsFull() throws Exception {
        //given
        int fieldInFullRowPosition = 150;
        int fieldInNotFullRowPosition = 140;
        int[] bottomFullRowFieldsPositions = {150, 151, 152, 153, 154, 155, 156, 157, 158, 159};
        int[] preBottomNotFullRowFieldsPositions = {140, 141, 142, 143, 145, 146, 147, 148, 149};
        Field fieldInFullRow = board.getField(fieldInFullRowPosition);
        Field fieldInNotFullRow = board.getField(fieldInNotFullRowPosition);
        Color pseudoRandomColor = Color.BLUE;
        //when
        for (int bottomFullRowFieldsPosition : bottomFullRowFieldsPositions) {
            board.getField(bottomFullRowFieldsPosition).placeField(pseudoRandomColor);
        }
        for (int preBottomNotFullRowFieldsPosition : preBottomNotFullRowFieldsPositions) {
            board.getField(preBottomNotFullRowFieldsPosition).placeField(pseudoRandomColor);
        }
        boolean trueAnswer = fieldInFullRow.isSideOfRowFull(Neighbour.RIGHT);
        boolean falseAnswer = fieldInNotFullRow.isSideOfRowFull(Neighbour.RIGHT);
        //then
        assertTrue(trueAnswer);
        assertFalse(falseAnswer);
    }
}