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

    @Before
    public void setUp() throws Exception {
        int width = 10;
        int height = 16;
        int fieldsNumber = width * height;
        board = new Board(width * height);
        for (int i=0; i<fieldsNumber; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
    }

    private List<Field> returnTileWithFieldsPositions(int[] positions) {
        List<Field> tile = new ArrayList<Field>();
        tile.add(board.getField(positions[0]));
        tile.add(board.getField(positions[1]));
        tile.add(board.getField(positions[2]));
        tile.add(board.getField(positions[3]));
        return tile;
    }

    @Test
    public void shouldSetJShapeTileHorizontalDown() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 24, 25};
        List<Field> lShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> lShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> lShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> lShapeTileHorizontalUp = returnTileWithFieldsPositions(horizontalUpPositions);
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