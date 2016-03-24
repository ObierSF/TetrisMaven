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
        int height = 16;
        int fieldsNumber = width * height;
        board = new Board(width, height);
        for (int i=0; i<fieldsNumber; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
    }

    @Test
    public void shouldNotFallBelowBottom() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] bottomPosition = {124, 134, 144, 154};
        int numberOfMovesTillBottom = 12;
        //when
        for (int i=0; i<numberOfMovesTillBottom; i++) {
            if (pseudoRandomTile.isMovePossible(Move.FALL)) {
                pseudoRandomTile.move(Move.FALL);
            }
        }
        //then
        for (int i=0; i<bottomPosition.length; i++) {
            assertEquals(bottomPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        if (pseudoRandomTile.isMovePossible(Move.FALL)) {
            pseudoRandomTile.move(Move.FALL);
        }
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
        for (int i=0; i<numberOfMovesTillRightBorder; i++) {
            if (pseudoRandomTile.isMovePossible(Move.RIGHT)) {
                pseudoRandomTile.move(Move.RIGHT);
            }
        }
        //then
        for (int i=0; i<extremeRightPosition.length; i++) {
            assertEquals(extremeRightPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        if (pseudoRandomTile.isMovePossible(Move.RIGHT)) {
            pseudoRandomTile.move(Move.RIGHT);
        }
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
        for (int i=0; i<numberOfMovesTillLeftBorder; i++) {
            if (pseudoRandomTile.isMovePossible(Move.LEFT)) {
                pseudoRandomTile.move(Move.LEFT);
            }
        }
        //then
        for (int i=0; i<extremeLeftPosition.length; i++) {
            assertEquals(extremeLeftPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        if (pseudoRandomTile.isMovePossible(Move.LEFT)) {
            pseudoRandomTile.move(Move.LEFT);
        }
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
        if (pseudoRandomTile.isMovePossible(Move.FALL)) {
            pseudoRandomTile.move(Move.FALL);
        }
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
        if (pseudoRandomTile.isMovePossible(Move.LEFT)) {
            pseudoRandomTile.move(Move.LEFT);
        }
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
        if (pseudoRandomTile.isMovePossible(Move.RIGHT)) {
            pseudoRandomTile.move(Move.RIGHT);
        }
        //then
        for (int i=0; i<tilePosition.length; i++) {
            assertEquals(tilePosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }
}