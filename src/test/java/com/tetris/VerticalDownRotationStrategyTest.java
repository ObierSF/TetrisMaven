package com.tetris;

import com.tetris.Tile.RotationVariant.RotationVariantStrategy;
import com.tetris.Tile.RotationVariant.ShapeRotation.IShapeRotation;
import com.tetris.Tile.RotationVariant.VerticalDownRotationStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 22.03.2016.
 */
public class VerticalDownRotationStrategyTest {
    Board board;

    @Before
    public void setUp() throws Exception {int width = 10;
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
    public void shouldReturnTrueIfTileWillBeVerticalDownAfterRotatingLeft() throws Exception {
        //given
        int[] horizontalUpTilePositions = { 13, 14, 15, 16};
        List<Field> horizontalUpTile = returnTileWithFieldsPositions(horizontalUpTilePositions);
        RotationVariantStrategy verticalDownRotationStrategy = new VerticalDownRotationStrategy();
        boolean strategyResponse;
        IShapeRotation iShapeRotation;
        //when
        if (strategyResponse = verticalDownRotationStrategy.validate(horizontalUpTile, "left")) {
            iShapeRotation = verticalDownRotationStrategy.getIShapeRotation();
        //then
            assertEquals(IShapeRotation.VERTICALDOWN, iShapeRotation);
        }
        assertTrue(strategyResponse);
    }

    @Test
    public void shouldReturnTrueIfTileWillBeVerticalDownAfterRotatingRight() throws Exception {
        //given
        int[] horizontalDownTilePositions = { 15, 14, 13, 12};
        List<Field> horizontalDownTile = returnTileWithFieldsPositions(horizontalDownTilePositions);
        RotationVariantStrategy verticalDownRotationStrategy = new VerticalDownRotationStrategy();
        boolean strategyResponse;
        IShapeRotation iShapeRotation;
        //when
        if (strategyResponse = verticalDownRotationStrategy.validate(horizontalDownTile, "right")) {
            iShapeRotation = verticalDownRotationStrategy.getIShapeRotation();
            //then
            assertEquals(IShapeRotation.VERTICALDOWN, iShapeRotation);
        }
        assertTrue(strategyResponse);
    }

    @Test
    public void shouldReturnFalseForNotProperTile() throws Exception {
        //given
        int[] horizontalDownTilePositions = { 15, 14, 13, 12};
        List<Field> horizontalDownTile = returnTileWithFieldsPositions(horizontalDownTilePositions);
        RotationVariantStrategy verticalDownRotationStrategy = new VerticalDownRotationStrategy();
        boolean strategyResponse;
        //when
        strategyResponse = verticalDownRotationStrategy.validate(horizontalDownTile, "left");
        //then
        assertFalse(strategyResponse);
    }
}