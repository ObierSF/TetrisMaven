package com.tetris.tiletest.rotationvarianttest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.IShapeRotation;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;
import com.tetris.tile.rotationvariantstrategy.VerticalUpRotationStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 22.03.2016.
 */
public class VerticalUpRotationStrategyTest {
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
    public void shouldReturnTrueIfTileWillBeVerticalUpAfterRotatingLeft() throws Exception {
        //given
        int[] horizontalDownTilePositions = { 15, 14, 13, 12};
        List<Field> horizontalDownTile = returnTileWithFieldsPositions(horizontalDownTilePositions);
        RotationVariantStrategy verticalUpRotationStrategy = new VerticalUpRotationStrategy();
        boolean strategyResponse;
        ShapeRotation ShapeRotation;
        //when
        if (strategyResponse = verticalUpRotationStrategy.validate(horizontalDownTile, RotationSide.LEFT)) {
            ShapeRotation = verticalUpRotationStrategy.getShapeRotation(Shape.I);
            //then
            assertEquals(IShapeRotation.VERTICALUP, ShapeRotation);
        }
        assertTrue(strategyResponse);
    }

    @Test
    public void shouldReturnTrueIfTileWillBeVerticalUpAfterRotatingRight() throws Exception {
        //given
        int[] horizontalUpTilePositions = { 13, 14, 15, 16};
        List<Field> horizontalUpTile = returnTileWithFieldsPositions(horizontalUpTilePositions);
        RotationVariantStrategy verticalUpRotationStrategy = new VerticalUpRotationStrategy();
        boolean strategyResponse;
        ShapeRotation ShapeRotation;
        //when
        if (strategyResponse = verticalUpRotationStrategy.validate(horizontalUpTile, RotationSide.RIGHT)) {
            ShapeRotation = verticalUpRotationStrategy.getShapeRotation(Shape.I);
        //then
            assertEquals(IShapeRotation.VERTICALUP, ShapeRotation);
        }
        assertTrue(strategyResponse);
    }

    @Test
    public void shouldReturnFalseForNotProperTile() throws Exception {
        //given
        int[] horizontalUpTilePositions = { 13, 14, 15, 16};
        List<Field> horizontalUpTile = returnTileWithFieldsPositions(horizontalUpTilePositions);
        RotationVariantStrategy verticalUpRotationStrategy = new VerticalUpRotationStrategy();
        boolean strategyResponse;
        //when
        strategyResponse = verticalUpRotationStrategy.validate(horizontalUpTile, RotationSide.LEFT);
        //then
        assertFalse(strategyResponse);
    }
}