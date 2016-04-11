package com.tetris.controllertest;

import com.tetris.Board;
import com.tetris.controller.MoveController;
import com.tetris.tile.IShapeTile;
import com.tetris.tile.Tile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 11.04.2016.
 */
public class MoveControllerTest {
    MoveController moveController;
    Tile pseudoRandomTile;
    Board board;

    @Before
    public void setUp() throws Exception {
        int width = 10;
        int height = 16;
        board = new Board(width * height);
        for (int i=0; i<width * height; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
        pseudoRandomTile = new IShapeTile(board);
        moveController = new MoveController(pseudoRandomTile);
    }

    @Test
    public void tileShoudMoveLeft() throws Exception {
        //given
        int[] positionsAfterMove = {3, 13, 23, 33};
        //when
        moveController.moveTileLeft();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShoudMoveRight() throws Exception {
        //given
        int[] positionsAfterMove = {5, 15, 25, 35};
        //when
        moveController.moveTileRight();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShouldFall() throws Exception {
        //given
        int[] positionsAfterMove = {14, 24, 34, 44};
        //when
        moveController.tileFall();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShouldRotateRight() throws Exception {
        //given
        int[] positionsAfterMove = {15, 14, 13, 12};
        //when
        moveController.rotateTileRight();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShouldRotateLeft() throws Exception {
        //given
        int[] positionsAfterMove = {13, 14, 15, 16};
        //when
        moveController.rotateTileLeft();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }
}
