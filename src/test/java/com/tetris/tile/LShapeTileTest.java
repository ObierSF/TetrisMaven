package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 31.03.2016.
 */
public class LShapeTileTest {
    Board board;
    Tile tile;

    @Before
    public void setUp() throws Exception {
        int width = 10;
        int height = 16;
        int fieldsNumber = width * height;
        board = new Board(width * height);
        tile = new LShapeTile(board);
    }

    @Test
    public void shouldRotateLeftWhenPossible() throws Exception {
        //given
        int[] firstRotationPositions = {13, 14, 15, 5};
        int[] secondRotationPositions = {24, 14, 4, 3};
        int[] thirdRotationPositions = {15, 14, 13, 23};
        int[] forthRotationPositions = {4, 14, 24, 25};
        //when
        tile.rotate(RotationSide.LEFT);
        //then
        for (int i=0; i<firstRotationPositions.length; i++) {
            assertEquals(firstRotationPositions[i], tile.getFieldPosition(i));
        }
        //when
        tile.rotate(RotationSide.LEFT);
        //then
        for (int i=0; i<secondRotationPositions.length; i++) {
            assertEquals(secondRotationPositions[i], tile.getFieldPosition(i));
        }
        //when
        tile.rotate(RotationSide.LEFT);
        //then
        for (int i=0; i<thirdRotationPositions.length; i++) {
            assertEquals(thirdRotationPositions[i], tile.getFieldPosition(i));
        }
        //when
        tile.rotate(RotationSide.LEFT);
        //then
        for (int i=0; i<forthRotationPositions.length; i++) {
            assertEquals(forthRotationPositions[i], tile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldRotateRightWhenPossible() throws Exception {
        //given
        int[] firstRotationPositions = {15, 14, 13, 23};
        int[] secondRotationPositions = {24, 14, 4, 3};
        int[] thirdRotationPositions = {13, 14, 15, 5};
        int[] forthRotationPositions = {4, 14, 24, 25};
        //when
        tile.rotate(RotationSide.RIGHT);
        //then
        for (int i=0; i<firstRotationPositions.length; i++) {
            assertEquals(firstRotationPositions[i], tile.getFieldPosition(i));
        }
        //when
        tile.rotate(RotationSide.RIGHT);
        //then
        for (int i=0; i<secondRotationPositions.length; i++) {
            assertEquals(secondRotationPositions[i], tile.getFieldPosition(i));
        }
        //when
        tile.rotate(RotationSide.RIGHT);
        //then
        for (int i=0; i<thirdRotationPositions.length; i++) {
            assertEquals(thirdRotationPositions[i], tile.getFieldPosition(i));
        }
        //when
        tile.rotate(RotationSide.RIGHT);
        //then
        for (int i=0; i<forthRotationPositions.length; i++) {
            assertEquals(forthRotationPositions[i], tile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldNotRotateWhenNotPossible() throws Exception {
        //given
        int[] position = {0, 10, 20, 21};
        //when
        for (int i=0; i<4; i++)
            tile.move(Move.LEFT);
        //then
        for (int i=0; i<position.length; i++) {
            assertEquals(position[i], tile.getFieldPosition(i));
        }
        //when
        tile.rotate(RotationSide.RIGHT);
        //then
        for (int i=0; i<position.length; i++) {
            assertEquals(position[i], tile.getFieldPosition(i));
        }
    }
}
