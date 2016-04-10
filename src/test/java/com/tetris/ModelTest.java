package com.tetris;

import com.tetris.controller.Controller;
import org.junit.Before;
import org.junit.Test;

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
        //when
        controller.setRandomTile();
        //then
        assertNotNull(controller.getTile());
    }

    @Test
    public void moveLeft() throws Exception {

    }
}