package com.tetris;

import com.tetris.Tile.RotationVariantStrategy.HorizontalUpRotationStrategy;
import com.tetris.Tile.RotationVariantStrategy.RotationVariantStrategy;
import com.tetris.Tile.RotationVariantStrategy.ShapeRotation.IShapeRotation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 22.03.2016.
 */
public class HorizontalUpRotationStrategyTest {
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
    public void shouldReturnTrueIfTileWillBeHorizontalUpAfterRotatingLeft() throws Exception {
        //given
        int[] verticalUpTilePositions = { 4, 14, 24, 34};
        List<Field> verticalUpTile = returnTileWithFieldsPositions(verticalUpTilePositions);
        RotationVariantStrategy horizontalUpRotationStrategy = new HorizontalUpRotationStrategy();
        boolean strategyResponse;
        IShapeRotation iShapeRotation;
        //when
        if (strategyResponse = horizontalUpRotationStrategy.validate(verticalUpTile, "left")) {
            iShapeRotation = horizontalUpRotationStrategy.getIShapeRotation();
        //then
            assertEquals(IShapeRotation.HORIZONTALUP, iShapeRotation);
        }
        assertTrue(strategyResponse);
    }

    @Test
    public void shouldReturnTrueIfTileWillBeHorizontalUpAfterRotatingRight() throws Exception {
        //given
        int[] verticalDownTilePositions = { 44, 34, 24, 14};
        List<Field> verticalDownTile = returnTileWithFieldsPositions(verticalDownTilePositions);
        RotationVariantStrategy horizontalUpRotationStrategy = new HorizontalUpRotationStrategy();
        boolean strategyResponse;
        IShapeRotation iShapeRotation;
        //when
        if (strategyResponse = horizontalUpRotationStrategy.validate(verticalDownTile, "right")) {
            iShapeRotation = horizontalUpRotationStrategy.getIShapeRotation();
        //then
            assertEquals(IShapeRotation.HORIZONTALUP, iShapeRotation);
        }
        assertTrue(strategyResponse);
    }

    @Test
    public void shouldReturnFalseForNotProperTile() throws Exception {
        //given
        int[] verticalDownTilePositions = { 44, 34, 24, 14};
        List<Field> verticalDownTile = returnTileWithFieldsPositions(verticalDownTilePositions);
        RotationVariantStrategy horizontalUpRotationStrategy = new HorizontalUpRotationStrategy();
        boolean strategyResponse;
        //when
        strategyResponse = horizontalUpRotationStrategy.validate(verticalDownTile, "left");
        //then
        assertFalse(strategyResponse);
    }
}