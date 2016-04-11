package com.tetris;

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
public class ModelTest {
    Controller controller;

    @Before
    public void setUp() throws Exception {
        int width = 10;
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
    public void tileShoudMoveLeft() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(controller.getBoard());
        int[] positionsAfterMove = {3, 13, 23, 33};
        //when
        controller.setTile(pseudoRandomTile);
        controller.moveTileLeft();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShoudMoveRight() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(controller.getBoard());
        int[] positionsAfterMove = {5, 15, 25, 35};
        //when
        controller.setTile(pseudoRandomTile);
        controller.moveTileRight();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShouldFall() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(controller.getBoard());
        int[] positionsAfterMove = {14, 24, 34, 44};
        //when
        controller.setTile(pseudoRandomTile);
        controller.tileFall();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShouldRotateRight() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(controller.getBoard());
        int[] positionsAfterMove = {15, 14, 13, 12};
        //when
        controller.setTile(pseudoRandomTile);
        controller.rotateTileRight();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void tileShouldRotateLeft() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(controller.getBoard());
        int[] positionsAfterMove = {13, 14, 15, 16};
        //when
        controller.setTile(pseudoRandomTile);
        controller.rotateTileLeft();
        //then
        for (int i=0; i<4; i++) {
            assertEquals(positionsAfterMove[i], pseudoRandomTile.getFieldPosition(i));
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
}