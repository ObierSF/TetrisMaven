package com.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 09.03.2016.
 */
public class IShapeTileTest {
    Board b;
    Tile t;

    @Before
    public void setUp() throws Exception {
        b = new Board(160);
        t = new IShapeTile(b);
    }

    /*@Test
    public void testRotateLeft() throws Exception {
        t.rotateLeft();
        assertEquals(13, t.getFieldPosition(0));
        assertEquals(14, t.getFieldPosition(1));
        assertEquals(15, t.getFieldPosition(2));
        assertEquals(16, t.getFieldPosition(3));
        t.rotateLeft();
        assertEquals(13, t.getFieldPosition(0));
        assertEquals(14, t.getFieldPosition(1));
        assertEquals(15, t.getFieldPosition(2));
        assertEquals(16, t.getFieldPosition(3));
        t.move(Move.FALL);
        t.rotateLeft();
        assertEquals(34, t.getFieldPosition(0));
        assertEquals(24, t.getFieldPosition(1));
        assertEquals(14, t.getFieldPosition(2));
        assertEquals(4, t.getFieldPosition(3));
        t.rotateLeft();
        assertEquals(25, t.getFieldPosition(0));
        assertEquals(24, t.getFieldPosition(1));
        assertEquals(23, t.getFieldPosition(2));
        assertEquals(22, t.getFieldPosition(3));
        t.rotateLeft();
        assertEquals(14, t.getFieldPosition(0));
        assertEquals(24, t.getFieldPosition(1));
        assertEquals(34, t.getFieldPosition(2));
        assertEquals(44, t.getFieldPosition(3));
    }

    @Test
    public void testRotateRight() throws Exception {
        t.rotateRight();
        assertEquals(15, t.getFieldPosition(0));
        assertEquals(14, t.getFieldPosition(1));
        assertEquals(13, t.getFieldPosition(2));
        assertEquals(12, t.getFieldPosition(3));
        t.rotateRight();
        assertEquals(15, t.getFieldPosition(0));
        assertEquals(14, t.getFieldPosition(1));
        assertEquals(13, t.getFieldPosition(2));
        assertEquals(12, t.getFieldPosition(3));
        t.move(Move.FALL);
        t.rotateRight();
        assertEquals(34, t.getFieldPosition(0));
        assertEquals(24, t.getFieldPosition(1));
        assertEquals(14, t.getFieldPosition(2));
        assertEquals(4, t.getFieldPosition(3));
        t.rotateRight();
        assertEquals(23, t.getFieldPosition(0));
        assertEquals(24, t.getFieldPosition(1));
        assertEquals(25, t.getFieldPosition(2));
        assertEquals(26, t.getFieldPosition(3));
        t.rotateRight();
        assertEquals(14, t.getFieldPosition(0));
        assertEquals(24, t.getFieldPosition(1));
        assertEquals(34, t.getFieldPosition(2));
        assertEquals(44, t.getFieldPosition(3));
    }

    @Test
    public void testRotateOverBorder() throws Exception {
        for (int i=0; i<4; i++)
            t.move(Move.LEFT);
        assertEquals(0, t.getFieldPosition(0));
        assertEquals(10, t.getFieldPosition(1));
        assertEquals(20, t.getFieldPosition(2));
        assertEquals(30, t.getFieldPosition(3));
        t.rotateRight();
        assertEquals(0, t.getFieldPosition(0));
        assertEquals(10, t.getFieldPosition(1));
        assertEquals(20, t.getFieldPosition(2));
        assertEquals(30, t.getFieldPosition(3));
    }*/
}