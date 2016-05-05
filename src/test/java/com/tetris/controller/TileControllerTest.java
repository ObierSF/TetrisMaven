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
    private TileController tileController;
    private int width;
    private Board board;

    @Before
    public void setUp() throws Exception {
        width = 10;
        int height = 16;
        board = new Board(width * height);
        tileController = new TileController(width, board);
    }

    @Test
    public void setTile() throws Exception {
        //given
        List<Field> fields;
        //when
        if (tileController.isAddingTilePossible()) {
            tileController.setRandomTile();
        }
        fields = tileController.getFields();
        //then
        assertNotNull(tileController.getTile());
        for (Field field : fields) {
            assertTrue(field.isPartOfTile());
        }
    }

    @Test
    public void fieldsShouldBePlacedAfterPlacing() throws Exception {
        //given
        if (tileController.isAddingTilePossible()) {
            tileController.setRandomTile();
        }
        Tile tile = tileController.getTile();
        List<Field> fields;
        //when
        tileController.placeTile();
        //then
        fields = tile.getFields();
        for (Field field : fields) {
            assertTrue(field.isPlacedField());
            assertFalse(field.isPartOfTile());
        }
    }

    @Test
    public void shouldReturnTrueIfFallIsPossible() {
        //given
        boolean answer;
        MoveController moveController = new MoveController();
        Tile pseudoRandomTile = new IShapeTile(board);
        moveController.setTile(pseudoRandomTile);
        tileController.setTile(pseudoRandomTile);
        //when
        answer = tileController.isFallPossible();
        //then
        assertTrue(answer);
        //when
        moveController.tileFallToBottom();
        answer = tileController.isFallPossible();
        //then
        assertFalse(answer);
    }
}