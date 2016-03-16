package com.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 09.03.2016.
 */
public class FieldTest {
    final int width = 10;
    final int height = 16;
    Field field;
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(160);
        //given random field from board
        field = board.board.get(4);
    }

    @Test
    public void shouldReturnTrueAfterFieldIsPlaced() throws Exception {
        //when
        field.placeField();
        //then
        assertTrue(field.placedField);
        assertFalse(field.partOfTile);
        assertFalse(field.isEmpty());
    }

    @Test
    public void shouldReturnTrueAfterFieldIsMadePartOfTile() throws Exception {
        //when
        field.makePartOfTile("RED");
        //then
        assertTrue(field.partOfTile);
        assertEquals(field.color, "RED");
        assertFalse(field.placedField);
        assertFalse(field.isEmpty());
    }

    @Test
    public void shouldReturnTrueAfterFieldIsEmptied() throws Exception {
        //when
        field.empty();
        //then
        assertTrue(field.isEmpty());
        assertFalse(field.partOfTile);
        assertFalse(field.placedField);
    }

    @Test
    public void shouldReturnLeftBorder() throws Exception {
        //given random left border position
        int position = width*7;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.LEFT, field.border);
    }

    @Test
    public void shouldReturnRightBorder() throws Exception {
        //given random right border position
        int position = width*12-1;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.RIGHT, field.border);
    }
    @Test
    public void shouldReturnTopBorder() throws Exception {
        //given random top border position
        int position = 1;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.TOP, field.border);
    }

    @Test
    public void shouldReturnBottomBorder() throws Exception {
        //given random bottom border position
        int position = height*width-2;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.BOTTOM, field.border);
    }

    @Test
    public void shouldReturnLeftTopCorner() throws Exception {
        //given left top position
        int position = 0;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.LEFTTOPCORNER, field.border);
    }

    @Test
    public void shouldReturnRightTopCorner() throws Exception {
        //given right top position
        int position = width - 1;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.RIGHTTOPCORNER, field.border);
    }

    @Test
    public void shouldReturnLeftBottomCorner() throws Exception {
        //given left bottom position
        int position = height*width-width;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.LEFTBOTTOMCORNER, field.border);
    }

    @Test
    public void shouldReturnRightBottomCorner() throws Exception {
        //given right bottom position
        int position = height*width-1;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.RIGHTBOTTOMCORNER, field.border);
    }

    @Test
    public void shouldReturnNonBorder() throws Exception {
        //given random non border position
        int position = width*14+8;
        //when
        field = board.board.get(position);
        //then
        assertEquals(Border.NONBORDER, field.border);
    }
}