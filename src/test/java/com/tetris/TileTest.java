package com.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 09.03.2016.
 */
public class TileTest {
    final int width = 10;
    Board board;

    @Before
    public void setUp() throws Exception {
        int fieldsNumber = 160;
        board = new Board(fieldsNumber);
        for (int i=0; i<fieldsNumber; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
    }

    @Test
    public void shouldReturnTrueForVerticalTile() throws Exception {
        //given
        Tile verticalTile = new IShapeTile(board);
        //then
        assertTrue(verticalTile.isVertical());
    }

    @Test
    public void shouldReturnFalseForUpSideDownTile() throws Exception {
        //given
        Tile notUpSideDownTile = new IShapeTile(board);
        //then
        assertFalse(notUpSideDownTile.isUpSideDown());
    }

    @Test
    public void shouldNotFallBelowBottom() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] bottomPosition = {124, 134, 144, 154};
        int numberOfMovesTillBottom = 12;
        //when
        for (int i=0; i<numberOfMovesTillBottom; i++)
            pseudoRandomTile.move(Move.FALL);
        //then
        for (int i=0; i<bottomPosition.length; i++) {
            assertEquals(bottomPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        pseudoRandomTile.move(Move.FALL);
        //then
        for (int i=0; i<bottomPosition.length; i++) {
            assertEquals(bottomPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldStopMovingWhenRightBorderIsReached() throws Exception {
        //given
        Tile pseudoRandomTile = new OShapeTile(board);
        int[] extremeRightPosition = {8, 9, 18, 19};
        int numberOfMovesTillRightBorder = 4;
        //when
        for (int i=0; i<numberOfMovesTillRightBorder; i++)
            pseudoRandomTile.move(Move.RIGHT);
        //then
        for (int i=0; i<extremeRightPosition.length; i++) {
            assertEquals(extremeRightPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        pseudoRandomTile.move(Move.RIGHT);
        //then
        for (int i=0; i<extremeRightPosition.length; i++) {
            assertEquals(extremeRightPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldStopMovingWhenLeftBorderIsReached() throws Exception {
        //given
        Tile pseudoRandomTile = new OShapeTile(board);
        int[] extremeLeftPosition = {0, 1, 10, 11};
        int numberOfMovesTillLeftBorder = 4;
        //when
        for (int i=0; i<numberOfMovesTillLeftBorder; i++)
            pseudoRandomTile.move(Move.LEFT);
        //then
        for (int i=0; i<extremeLeftPosition.length; i++) {
            assertEquals(extremeLeftPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        pseudoRandomTile.move(Move.LEFT);
        //then
        for (int i=0; i<extremeLeftPosition.length; i++) {
            assertEquals(extremeLeftPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldNotFallWhenFieldBelowIsNotEmpty() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] tilePosition = {4, 14, 24, 34};
        int belowFieldPosition = 44;
        //when
        board.getField(belowFieldPosition).placeField();
        pseudoRandomTile.move(Move.FALL);
        //then
        for (int i=0; i<tilePosition.length; i++) {
            assertEquals(tilePosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldNotMoveLeftWhenFieldIsNotAvailable() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] tilePosition = {4, 14, 24, 34};
        int placedLeftFieldPosition = 13;
        //when
        board.getField(placedLeftFieldPosition).placeField();
        pseudoRandomTile.move(Move.LEFT);
        //then
        for (int i=0; i<tilePosition.length; i++) {
            assertEquals(tilePosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldNotMoveRightWhenFieldIsNotAvailable() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] tilePosition = {4, 14, 24, 34};
        int placedRightFieldPosition = 35;
        //when
        board.getField(placedRightFieldPosition).placeField();
        pseudoRandomTile.move(Move.RIGHT);
        //then
        for (int i=0; i<tilePosition.length; i++) {
            assertEquals(tilePosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }
}