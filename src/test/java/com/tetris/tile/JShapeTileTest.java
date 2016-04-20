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
public class JShapeTileTest {
    Board board;
    Tile tile;

    @Before
    public void setUp() throws Exception {
        int width = 10;
        int height = 16;
        int fieldsNumber = width * height;
        board = new Board(width * height);
        tile = new JShapeTile(board);
    }

    @Test
    public void shouldRotateLeftWhenPossible() throws Exception {
        //given
        int[] firstRotationPositions = {14, 15, 16, 26};
        int[] secondRotationPositions = {25, 15, 5, 6};
        int[] thirdRotationPositions = {16, 15, 14, 4};
        int[] forthRotationPositions = {5, 15, 25, 24};
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
        int[] firstRotationPositions = {16, 15, 14, 4};
        int[] secondRotationPositions = {25, 15, 5, 6};
        int[] thirdRotationPositions = {14, 15, 16, 26};
        int[] forthRotationPositions = {5, 15, 25, 24};
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
        int[] position = {9, 19, 29, 28};
        //when
        for (int i=0; i<4; i++)
            tile.move(Move.RIGHT);
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
