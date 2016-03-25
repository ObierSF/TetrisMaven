package com.tetris;

import com.tetris.Tile.RotationVariantStrategy.ShapeRotation.JShapeRotation;
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
        int[] verticalUpPositions = {4, 14, 24, 23};
        List<Field> jShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> jShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> jShapeTileVerticalUp = returnTileWithFieldsPositions(verticalUpPositions);
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
        List<Field> jShapeTileHorizontalUp = returnTileWithFieldsPositions(horizontalUpPositions);
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