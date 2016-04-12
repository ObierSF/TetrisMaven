package com.tetris.controllertest;

import com.tetris.Board;
import com.tetris.controller.MoveController;
import com.tetris.field.Field;
import com.tetris.controller.Controller;
import com.tetris.tile.IShapeTile;
import com.tetris.tile.Tile;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 22.03.2016.
 */
public class ControllerTest {
    private Controller controller;
    private int width;

    @Before
    public void setUp() throws Exception {
        width = 10;
        int height = 16;
        controller = new Controller(width, height);
    }

    @Test
    public void setTile() throws Exception {
        //given
        List<Field> fields;
        //when
        controller.setRandomTile();
        fields = controller.getTile().getFields();
        //then
        assertNotNull(controller.getTile());
        for (Field field : fields) {
            assertTrue(field.isPartOfTile());
        }
    }

    @Test
    public void fieldsShouldBePlacedAfterPlacing() throws Exception {
        //given
        controller.setRandomTile();
        Tile tile = controller.getTile();
        List<Field> fields;
        //when
        controller.placeTile();
        //then
        fields = tile.getFields();
        for (Field field : fields) {
            assertTrue(field.isPlacedField());
            assertFalse(field.isPartOfTile());
        }
    }

    @Test
    public void rowsShouldBeCountedAndCleared() {
        //given
        Board board = controller.getBoard();
        Tile pseudoRandomTile = new IShapeTile(board);
        MoveController moveController = new MoveController(pseudoRandomTile);
        int expectedScore = 200;
        int[] bottomFullRowFieldsPositions = {150, 151, 152, 153, 155, 156, 157, 158, 159};
        int[] preBottomFullRowFieldsPositions = {140, 141, 142, 143, 145, 146, 147, 148, 149};
        controller.setTile(pseudoRandomTile);
        //when
        for (int i=0; i<bottomFullRowFieldsPositions.length; i++) {
            board.getField(bottomFullRowFieldsPositions[i]).placeField();
            board.getField(preBottomFullRowFieldsPositions[i]).placeField();
        }
        moveController.tileFallToBottom();
        controller.placeTile();
        controller.searchForFullRows();
        controller.sumScore();
        controller.clearFullRows();
        //then
        assertEquals(expectedScore, controller.getScore());
        for (int i=0; i<bottomFullRowFieldsPositions.length; i++) {
            assertTrue(board.getField(bottomFullRowFieldsPositions[i]).isEmpty());
            assertTrue(board.getField(preBottomFullRowFieldsPositions[i]).isEmpty());
        }
    }
}