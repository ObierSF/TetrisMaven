package com.tetris.controller;

import com.tetris.Board;
import com.tetris.field.Field;
import com.tetris.tile.IShapeTile;
import com.tetris.tile.Tile;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 22.03.2016.
 */
public class TileControllerTest {
    private TileController controller;
    private int width;
    private Board board;

    @Before
    public void setUp() throws Exception {
        width = 10;
        int height = 16;
        board = new Board(width * height);
        controller = new TileController(width, board);
    }

    @Test
    public void setTile() throws Exception {
        //given
        List<Field> fields;
        //when
        if (controller.isAddingTilePossible()) {
            controller.setRandomTile();
        }
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
        if (controller.isAddingTilePossible()) {
            controller.setRandomTile();
        }
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
        Tile pseudoRandomTile = new IShapeTile(board);
        MoveController moveController = new MoveController();
        moveController.setTile(pseudoRandomTile);
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
        //then
        for (int i=0; i<bottomFullRowFieldsPositions.length; i++) {
//            assertTrue(board.getField(bottomFullRowFieldsPositions[i]).isEmpty());
//            assertTrue(board.getField(preBottomFullRowFieldsPositions[i]).isEmpty());
        }
    }
}