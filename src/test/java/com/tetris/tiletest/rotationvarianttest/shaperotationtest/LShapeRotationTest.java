package com.tetris.tiletest.rotationvarianttest.shaperotationtest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.shaperotation.LShapeRotation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 23.03.2016.
 */
public class LShapeRotationTest {
    Board board;
    TileCreator tileCreator;

    @Before
    public void setUp() throws Exception {
        int fieldsNumber = 160;
        board = new Board(fieldsNumber);
        for (int i=0; i<fieldsNumber; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
        tileCreator = new TileCreator();
    }

    @Test
    public void shouldSetJShapeTileHorizontalDown() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 24, 25};
        List<Field> lShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalDownPositions = {15, 14, 13, 23};
        //when
        if (LShapeRotation.HORIZONTALDOWN.isPossible(lShapeTileVerticalUp)) {
            LShapeRotation.HORIZONTALDOWN.rotate(lShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalDownPositions.length; i++) {
            assertEquals(horizontalDownPositions[i], lShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetJShapeTileVerticalDown() throws Exception {
        //given
        int[] verticalUpPositions = {14, 24, 34, 35};
        List<Field> lShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] verticalDownPositions = {34, 24, 14, 13};
        //when
        if (LShapeRotation.VERTICALDOWN.isPossible(lShapeTileVerticalUp)) {
            LShapeRotation.VERTICALDOWN.rotate(lShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<verticalDownPositions.length; i++) {
            assertEquals(verticalDownPositions[i], lShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileHorizontalUp() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 24, 25};
        List<Field> lShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalUpPositions = {13, 14, 15, 5};
        //when
        if (LShapeRotation.HORIZONTALUP.isPossible(lShapeTileVerticalUp)) {
            LShapeRotation.HORIZONTALUP.rotate(lShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalUpPositions.length; i++) {
            assertEquals(horizontalUpPositions[i], lShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileVerticalUp() throws Exception {
        //given
        int[] horizontalUpPositions = {13, 14, 15, 5};
        List<Field> lShapeTileHorizontalUp = tileCreator.returnTileWithFieldsPositions(horizontalUpPositions, board);
        int[] verticalUpPositions = {4, 14, 24, 25};
        //when
        if (LShapeRotation.VERTICALUP.isPossible(lShapeTileHorizontalUp)) {
            LShapeRotation.VERTICALUP.rotate(lShapeTileHorizontalUp);
        }
        //then
        for (int i=0; i<verticalUpPositions.length; i++) {
            assertEquals(verticalUpPositions[i], lShapeTileHorizontalUp.get(i).getPosition());
        }
    }
}