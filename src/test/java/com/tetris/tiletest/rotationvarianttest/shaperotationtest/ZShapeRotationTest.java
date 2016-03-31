package com.tetris.tiletest.rotationvarianttest.shaperotationtest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ZShapeRotation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 23.03.2016.
 */
public class ZShapeRotationTest {
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
        int[] verticalUpPositions = {4, 14, 13, 23};
        List<Field> zShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalDownPositions = {15, 14, 4, 3};
        //when
        if (ZShapeRotation.HORIZONTALDOWN.isPossible(zShapeTileVerticalUp)) {
            ZShapeRotation.HORIZONTALDOWN.rotate(zShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalDownPositions.length; i++) {
            assertEquals(horizontalDownPositions[i], zShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetJShapeTileVerticalDown() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 13, 23};
        List<Field> zShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] verticalDownPositions = {24, 14, 15, 5};
        //when
        if (ZShapeRotation.VERTICALDOWN.isPossible(zShapeTileVerticalUp)) {
            ZShapeRotation.VERTICALDOWN.rotate(zShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<verticalDownPositions.length; i++) {
            assertEquals(verticalDownPositions[i], zShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileHorizontalUp() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 13, 23};
        List<Field> zShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalUpPositions = {13, 14, 24, 25};
        //when
        if (ZShapeRotation.HORIZONTALUP.isPossible(zShapeTileVerticalUp)) {
            ZShapeRotation.HORIZONTALUP.rotate(zShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalUpPositions.length; i++) {
            assertEquals(horizontalUpPositions[i], zShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileVerticalUp() throws Exception {
        //given
        int[] horizontalUpPositions = {13, 14, 24, 25};
        List<Field> zShapeTileHorizontalUp = tileCreator.returnTileWithFieldsPositions(horizontalUpPositions, board);
        int[] verticalUpPositions = {4, 14, 13, 23};
        //when
        if (ZShapeRotation.VERTICALUP.isPossible(zShapeTileHorizontalUp)) {
            ZShapeRotation.VERTICALUP.rotate(zShapeTileHorizontalUp);
        }
        //then
        for (int i=0; i<verticalUpPositions.length; i++) {
            assertEquals(verticalUpPositions[i], zShapeTileHorizontalUp.get(i).getPosition());
        }
    }
}