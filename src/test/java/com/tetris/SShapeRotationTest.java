package com.tetris;

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

    @Before
    public void setUp() throws Exception {
        int width = 10;
        int height = 16;
        int fieldsNumber = width * height;
        board = new Board(width, height);
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
        int[] verticalUpPositions = {4, 14, 15, 25};
        List<Field> sShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> sShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> sShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> sShapeTileHorizontalUp = returnTileWithFieldsPositions(horizontalUpPositions);
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