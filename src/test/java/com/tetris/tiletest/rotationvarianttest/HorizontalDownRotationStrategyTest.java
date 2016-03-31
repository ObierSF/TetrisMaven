package com.tetris.tiletest.rotationvarianttest;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationvariantstrategy.HorizontalDownRotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ishaperotation.IShapeRotation;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalDownRotationStrategyTest {
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
    public void shouldReturnProperRotationVariantIfTileWillBeHorizontalDownAfterRotatingLeft() throws Exception {
        //given
        int[] verticalDownTilePositions = { 34, 24, 14, 4};
        List<Field> verticalDownTile = returnTileWithFieldsPositions(verticalDownTilePositions);
        RotationVariantStrategy horizontalDownRotationStrategy = new HorizontalDownRotationStrategy();
        boolean strategyResponse;
        ShapeRotation iShapeRotation;
        //when
        if (strategyResponse = horizontalDownRotationStrategy.validate(verticalDownTile, RotationSide.LEFT)) {
            iShapeRotation = horizontalDownRotationStrategy.getShapeRotation(Shape.I);
            //then
            assertEquals(IShapeRotation.HORIZONTALDOWN, iShapeRotation);
        }
        assertTrue(strategyResponse);
    }

    @Test
    public void shouldReturnProperRotationVariantIfTileWillBeHorizontalDownAfterRotatingRight() throws Exception {
        //given
        int[] verticalUpTilePositions = { 4, 14, 24, 34};
        List<Field> verticalUpTile = returnTileWithFieldsPositions(verticalUpTilePositions);
        RotationVariantStrategy horizontalDownRotationStrategy = new HorizontalDownRotationStrategy();
        boolean strategyResponse;
        ShapeRotation iShapeRotation;
        //when
        if (strategyResponse = horizontalDownRotationStrategy.validate(verticalUpTile, RotationSide.RIGHT)) {
            iShapeRotation = horizontalDownRotationStrategy.getShapeRotation(Shape.I);
        //then
            assertEquals(IShapeRotation.HORIZONTALDOWN, iShapeRotation);
        }
        assertTrue(strategyResponse);
    }

    @Test
    public void shouldReturnFalseForNotProperTile() throws Exception {
        //given
        int[] verticalUpTilePositions = { 4, 14, 24, 34};
        List<Field> verticalUpTile = returnTileWithFieldsPositions(verticalUpTilePositions);
        RotationVariantStrategy horizontalDownRotationStrategy = new HorizontalDownRotationStrategy();
        boolean strategyResponse;
        //when
        strategyResponse = horizontalDownRotationStrategy.validate(verticalUpTile, RotationSide.LEFT);
        //then
        assertFalse(strategyResponse);
    }
}