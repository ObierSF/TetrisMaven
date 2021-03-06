package com.tetris.controller;

import com.tetris.Board;
import com.tetris.tile.IShapeTile;
import com.tetris.tile.Tile;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by User on 11.04.2016.
 */
public class MoveControllerTest {
    private MoveController moveController;
    private Tile pseudoRandomTile;
    private Board board;

    @Before
    public void setUp() throws Exception {
        int width = 10;
        int height = 16;
        board = new Board(width * height);
        pseudoRandomTile = new IShapeTile(board);
        moveController = new MoveController();
        moveController.setTile(pseudoRandomTile);
    }

    @Test
    public void tileShoudMoveLeft() throws Exception {
        //given
        int[] positionsAfterMove = {3, 13, 23, 33};
        //when
        moveController.moveTile(Move.LEFT);
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
        moveController.moveTile(Move.RIGHT);
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
        moveController.moveTile(Move.FALL);
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
        moveController.rotateTile(RotationSide.RIGHT);
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
        moveController.rotateTile(RotationSide.LEFT);
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShouldFallToBottom() throws Exception {
        //given
        int[] positionsAfterMove = {124, 134, 144, 154};
        //when
        moveController.tileFallToBottom();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }
}
