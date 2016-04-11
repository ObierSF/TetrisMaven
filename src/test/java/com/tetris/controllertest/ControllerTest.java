package com.tetris.controllertest;

import com.tetris.Field;
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