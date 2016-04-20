package com.tetris.field;

import com.tetris.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 19.04.2016.
 */
public class SurroundingFieldsTest {
    private Board board;

    @Before
    public void setUp() throws Exception {
        int fieldsNumber = 160;
        board = new Board(fieldsNumber);
    }

    @Test
    public void shouldReturnProperNeighbours() throws Exception {
        //given
        int leftBorderPosition = 40;
        Field leftBorderField = board.getField(leftBorderPosition);
        int     upperNeightbourPosition = 30,
                lowerNeightbourPosition = 50,
                rightNeightbourPosition = 41;
        Field upperNeighbour, lowerNeighbour, leftNeighbour, rightNeighbour;
        SurroundingFields surroundingFields = leftBorderField.getSurroundingFields();
        //when
        upperNeighbour = surroundingFields.getNeighbour(Neighbour.UPPER);
        lowerNeighbour = surroundingFields.getNeighbour(Neighbour.LOWER);
        leftNeighbour = surroundingFields.getNeighbour(Neighbour.LEFT);
        rightNeighbour = surroundingFields.getNeighbour(Neighbour.RIGHT);
        //then
        assertEquals(upperNeightbourPosition, upperNeighbour.getPosition());
        assertEquals(lowerNeightbourPosition, lowerNeighbour.getPosition());
        assertEquals(rightNeightbourPosition, rightNeighbour.getPosition());
        assertNull(leftNeighbour);
    }
}