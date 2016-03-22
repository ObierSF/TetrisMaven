package com.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 22.03.2016.
 */
public class ModelTest {
    Model model;
    @Before
    public void setUp() throws Exception {
        int width = 10;
        int height = 16;
        model = new Model(width, height);
    }
}