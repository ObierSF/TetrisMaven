package com.tetris;

import com.tetris.Tile.RotationVariantStrategy.ShapeRotation.TShapeRotation;
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
        int[] verticalUpPositions = {4, 14, 24, 13};
        List<Field> tShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> tShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> tShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> tShapeTileHorizontalUp = returnTileWithFieldsPositions(horizontalUpPositions);
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