package com.tetris.tiletest.movetest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.move.Move;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 17.03.2016.
 */
public class MoveTest {
    final int width = 10;
    Board board;
    int[] iShapeTilePositions;
    List<Field> pseudoRandomTile;
    String color;

    @Before
    public void setUp() {
        int width = 10;
        int height = 16;
        int fieldsNumber = width * height;
        board = new Board(width * height);
        for (int i=0; i<fieldsNumber; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
        //given
        iShapeTilePositions = new int[]{4, 14, 24, 34};
        pseudoRandomTile = new ArrayList<Field>();
        for (int i=0; i<iShapeTilePositions.length; i++) {
            pseudoRandomTile.add(board.getField(iShapeTilePositions[i]));
        }
        color = "RED";
    }

    /*@Test
    public void tileShouldFall() throws Exception {
        //when
        if (Move.FALL.isPossible(pseudoRandomTile)) {
            Move.FALL.move(pseudoRandomTile, color);
        }
        //then
        int i = 0;
        for (Field field : pseudoRandomTile) {
            assertEquals(iShapeTilePositions[i] + width, field.getPosition());
            i++;
        }
        assertTrue(board.getField(iShapeTilePositions[0]).isEmpty());
    }

    @Test
    public void tileShouldMoveLeft() throws Exception {
        //when
        if (Move.LEFT.isPossible(pseudoRandomTile)) {
            Move.LEFT.move(pseudoRandomTile, color);
        }
        //then
        int i = 0;
        for (Field field : pseudoRandomTile) {
            assertEquals(iShapeTilePositions[i] - 1, field.getPosition());
            assertTrue(board.getField(iShapeTilePositions[i]).isEmpty());
            i++;
        }
    }

    @Test
    public void tileShouldMoveRight() throws Exception {
        //when
        if (Move.RIGHT.isPossible(pseudoRandomTile)) {
            Move.RIGHT.move(pseudoRandomTile, color);
        }
        //then
        int i = 0;
        for (Field field : pseudoRandomTile) {
            assertEquals(iShapeTilePositions[i] + 1, field.getPosition());
            assertTrue(board.getField(iShapeTilePositions[i]).isEmpty());
            i++;
        }
    }

    @Test
    public void shouldNotFallWhenFieldIsNotAvailable() throws Exception {
        //given
        int belowFieldPosition = 44;
        board.getField(belowFieldPosition).placeField();
        boolean moveResponse;
        //when
        moveResponse = Move.FALL.isPossible(pseudoRandomTile);
        //then
        assertFalse(moveResponse);
    }

    @Test
    public void shouldNotMoveLeftWhenFieldIsNotAvailable() throws Exception {
        //given
        int placedLeftFieldPosition = 23;
        board.getField(placedLeftFieldPosition).placeField();
        boolean moveResponse;
        //when
        moveResponse = Move.LEFT.isPossible(pseudoRandomTile);
        //then
        assertFalse(moveResponse);
    }

    @Test
    public void shouldNotMoveRightWhenFieldIsNotAvailable() throws Exception {
        //given
        int placedRightFieldPosition = 15;
        board.getField(placedRightFieldPosition).placeField();
        boolean moveResponse;
        //when
        moveResponse = Move.RIGHT.isPossible(pseudoRandomTile);
        //then
        assertFalse(moveResponse);
    }*/
}