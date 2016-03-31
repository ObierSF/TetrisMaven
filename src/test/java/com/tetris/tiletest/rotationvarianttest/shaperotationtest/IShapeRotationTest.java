package com.tetris.tiletest.rotationvarianttest.shaperotationtest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ishaperotation.IShapeRotation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 22.03.2016.
 */
public class IShapeRotationTest {
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
    public void shouldSetIShapeTileHorizontalDown() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 24, 34};
        List<Field> iShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalDownPositions = {15, 14, 13, 12};
        //when
        if (IShapeRotation.HORIZONTALDOWN.isPossible(iShapeTileVerticalUp)) {
            IShapeRotation.HORIZONTALDOWN.rotate(iShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalDownPositions.length; i++) {
            assertEquals(horizontalDownPositions[i], iShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileVerticalDown() throws Exception {
        //given
        int[] verticalUpPositions = {14, 24, 34, 44};
        List<Field> iShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] verticalDownPositions = {34, 24, 14, 4};
        //when
        if (IShapeRotation.VERTICALDOWN.isPossible(iShapeTileVerticalUp)) {
            IShapeRotation.VERTICALDOWN.rotate(iShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<verticalDownPositions.length; i++) {
            assertEquals(verticalDownPositions[i], iShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileHorizontalUp() throws Exception {
        //given
        int[] verticalUpPositions = {4, 14, 24, 34};
        List<Field> iShapeTileVerticalUp = tileCreator.returnTileWithFieldsPositions(verticalUpPositions, board);
        int[] horizontalUpPositions = {13, 14, 15, 16};
        //when
        if (IShapeRotation.HORIZONTALUP.isPossible(iShapeTileVerticalUp)) {
            IShapeRotation.HORIZONTALUP.rotate(iShapeTileVerticalUp);
        }
        //then
        for (int i=0; i<horizontalUpPositions.length; i++) {
            assertEquals(horizontalUpPositions[i], iShapeTileVerticalUp.get(i).getPosition());
        }
    }

    @Test
    public void shouldSetIShapeTileVerticalUp() throws Exception {
        //given
        int[] horizontalUpPositions = {13, 14, 15, 16};
        List<Field> iShapeTileHorizontalUp = tileCreator.returnTileWithFieldsPositions(horizontalUpPositions, board);
        int[] verticalUpPositions = {4, 14, 24, 34};
        //when
        if (IShapeRotation.VERTICALUP.isPossible(iShapeTileHorizontalUp)) {
            IShapeRotation.VERTICALUP.rotate(iShapeTileHorizontalUp);
        }
        //then
        for (int i=0; i<verticalUpPositions.length; i++) {
            assertEquals(verticalUpPositions[i], iShapeTileHorizontalUp.get(i).getPosition());
        }
    }
}