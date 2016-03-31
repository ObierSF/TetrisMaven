package com.tetris.tiletest.rotationvarianttest.shaperotationtest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.shaperotation.TShapeRotation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 23.03.2016.
 */
public class TShapeRotationTest {
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
        int[] verticalUpPositions = {4, 14, 24, 13};
        List<Field> tShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalDownPositions = {15, 14, 13, 4};
        //when
        if (TShapeRotation.HORIZONTALDOWN.isPossible(tShapeTileVerticalUp)) {
            TShapeRotation.HORIZONTALDOWN.rotate(tShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalDownPositions.length; i++) {
            assertEquals(horizontalDownPositions[i], tShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetJShapeTileVerticalDown() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 24, 13};
        List<Field> tShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] verticalDownPositions = {24, 14, 4, 15};
        //when
        if (TShapeRotation.VERTICALDOWN.isPossible(tShapeTileVerticalUp)) {
            TShapeRotation.VERTICALDOWN.rotate(tShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<verticalDownPositions.length; i++) {
            assertEquals(verticalDownPositions[i], tShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileHorizontalUp() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 24, 13};
        List<Field> tShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalUpPositions = {13, 14, 15, 24};
        //when
        if (TShapeRotation.HORIZONTALUP.isPossible(tShapeTileVerticalUp)) {
            TShapeRotation.HORIZONTALUP.rotate(tShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalUpPositions.length; i++) {
            assertEquals(horizontalUpPositions[i], tShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileVerticalUp() throws Exception {
        //given
        int[] horizontalUpPositions = {13, 14, 15, 24};
        List<Field> tShapeTileHorizontalUp = tileCreator.returnTileWithFieldsPositions(horizontalUpPositions, board);
        int[] verticalUpPositions = {4, 14, 24, 13};
        //when
        if (TShapeRotation.VERTICALUP.isPossible(tShapeTileHorizontalUp)) {
            TShapeRotation.VERTICALUP.rotate(tShapeTileHorizontalUp);
        }
        //then
        for (int i=0; i<verticalUpPositions.length; i++) {
            assertEquals(verticalUpPositions[i], tShapeTileHorizontalUp.get(i).getPosition());
        }
    }
}