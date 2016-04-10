package com.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 06.04.2016.
 */
public class BoardTest {
    Board board;

    @Before
    public void setUp() throws Exception {
        int fieldsNumber = 160;
        board = new Board(160);
    }

    @Test
    public void shouldReturnProperField() throws Exception {
        //given
        int pseudoRandomFieldPosition = 14;
        Field field;
        //when
        field = board.getField(pseudoRandomFieldPosition);
        //then
        assertEquals(field.getPosition(), pseudoRandomFieldPosition);
    }
}