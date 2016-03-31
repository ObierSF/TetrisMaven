package com.tetris.tiletest.rotationvarianttest.shaperotationtest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.shaperotation.SShapeRotation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 23.03.2016.
 */
public class SShapeRotationTest {
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
        int[] verticalUpPositions = {4, 14, 15, 25};
        List<Field> sShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalDownPositions = {15, 14, 24, 23};
        //when
        if (SShapeRotation.HORIZONTALDOWN.isPossible(sShapeTileVerticalUp)) {
            SShapeRotation.HORIZONTALDOWN.rotate(sShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalDownPositions.length; i++) {
            assertEquals(horizontalDownPositions[i], sShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetJShapeTileVerticalDown() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 15, 25};
        List<Field> sShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] verticalDownPositions = {24, 14, 13, 3};
        //when
        if (SShapeRotation.VERTICALDOWN.isPossible(sShapeTileVerticalUp)) {
            SShapeRotation.VERTICALDOWN.rotate(sShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<verticalDownPositions.length; i++) {
            assertEquals(verticalDownPositions[i], sShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileHorizontalUp() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 15, 25};
        List<Field> sShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalUpPositions = {13, 14, 4, 5};
        //when
        if (SShapeRotation.HORIZONTALUP.isPossible(sShapeTileVerticalUp)) {
            SShapeRotation.HORIZONTALUP.rotate(sShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalUpPositions.length; i++) {
            assertEquals(horizontalUpPositions[i], sShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileVerticalUp() throws Exception {
        //given
        int[] horizontalUpPositions = {13, 14, 4, 5};
        List<Field> sShapeTileHorizontalUp = tileCreator.returnTileWithFieldsPositions(horizontalUpPositions, board);
        int[] verticalUpPositions = {4, 14, 15, 25};
        //when
        if (SShapeRotation.VERTICALUP.isPossible(sShapeTileHorizontalUp)) {
            SShapeRotation.VERTICALUP.rotate(sShapeTileHorizontalUp);
        }
        //then
        for (int i=0; i<verticalUpPositions.length; i++) {
            assertEquals(verticalUpPositions[i], sShapeTileHorizontalUp.get(i).getPosition());
        }
    }
}