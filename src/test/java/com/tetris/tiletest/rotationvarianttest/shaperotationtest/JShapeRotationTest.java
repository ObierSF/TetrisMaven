package com.tetris.tiletest.rotationvarianttest.shaperotationtest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.shaperotation.JShapeRotation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 23.03.2016.
 */
public class JShapeRotationTest {
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
        int[] verticalUpPositions = {4, 14, 24, 23};
        List<Field> jShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalDownPositions = {15, 14, 13, 3};
        //when
        if (JShapeRotation.HORIZONTALDOWN.isPossible(jShapeTileVerticalUp)) {
            JShapeRotation.HORIZONTALDOWN.rotate(jShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalDownPositions.length; i++) {
            assertEquals(horizontalDownPositions[i], jShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetJShapeTileVerticalDown() throws Exception {
        //given
        int[] verticalUpPositions = {14, 24, 34, 33};
        List<Field> jShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] verticalDownPositions = {34, 24, 14, 15};
        //when
        if (JShapeRotation.VERTICALDOWN.isPossible(jShapeTileVerticalUp)) {
            JShapeRotation.VERTICALDOWN.rotate(jShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<verticalDownPositions.length; i++) {
            assertEquals(verticalDownPositions[i], jShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileHorizontalUp() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 24, 23};
        List<Field> jShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalUpPositions = {13, 14, 15, 25};
        //when
        if (JShapeRotation.HORIZONTALUP.isPossible(jShapeTileVerticalUp)) {
            JShapeRotation.HORIZONTALUP.rotate(jShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalUpPositions.length; i++) {
            assertEquals(horizontalUpPositions[i], jShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileVerticalUp() throws Exception {
        //given
        int[] horizontalUpPositions = {13, 14, 15, 25};
        List<Field> jShapeTileHorizontalUp = tileCreator.returnTileWithFieldsPositions(horizontalUpPositions, board);
        int[] verticalUpPositions = {4, 14, 24, 23};
        //when
        if (JShapeRotation.VERTICALUP.isPossible(jShapeTileHorizontalUp)) {
            JShapeRotation.VERTICALUP.rotate(jShapeTileHorizontalUp);
        }
        //then
        for (int i=0; i<verticalUpPositions.length; i++) {
            assertEquals(verticalUpPositions[i], jShapeTileHorizontalUp.get(i).getPosition());
        }
    }
}