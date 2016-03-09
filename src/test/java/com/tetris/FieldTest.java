package com.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 09.03.2016.
 */
public class FieldTest {
    Field f;
    Board b;

    @Before
    public void setUp() throws Exception {
        b = new Board(160);
        f = b.board.get(4);
    }

    @Test
    public void testLocate() throws Exception {
        f.locate();
        assertFalse(f.isPartOfTile);
        assertTrue(f.isLocated);
        assertFalse(f.isEmpty());
    }

    @Test
    public void testMakePartOfTile() throws Exception {
        f.makePartOfTile("RED");
        assertTrue(f.isPartOfTile);
        assertFalse(f.isLocated);
        assertEquals(f.color, "RED");
        assertFalse(f.isEmpty());
    }

    @Test
    public void testEmpty() throws Exception {
        f.empty();
        assertFalse(f.isPartOfTile);
        assertFalse(f.isLocated);
        assertTrue(f.isEmpty());
    }

    @Test
    public void testLeftBorderField() throws Exception {
        f = b.board.get(20);
        assertEquals(Border.LEFT, f.border);
    }

    @Test
    public void testRightBorderField() throws Exception {
        f = b.board.get(59);
        assertEquals(Border.RIGHT, f.border);
    }
    @Test
    public void testTopBorderField() throws Exception {
        f = b.board.get(4);
        assertEquals(Border.TOP, f.border);
    }

    @Test
    public void testBottomBorderField() throws Exception {
        f = b.board.get(158);
        assertEquals(Border.BOTTOM, f.border);
    }

    @Test
    public void testLTCornerBorderField() throws Exception {
        f = b.board.get(0);
        assertEquals(Border.LTCORNER, f.border);
    }

    @Test
    public void testRTCornerBorderField() throws Exception {
        f = b.board.get(9);
        assertEquals(Border.RTCORNER, f.border);
    }

    @Test
    public void testLBCornerBorderField() throws Exception {
        f = b.board.get(150);
        assertEquals(Border.LBCORNER, f.border);
    }

    @Test
    public void testRBCornerBorderField() throws Exception {
        f = b.board.get(159);
        assertEquals(Border.RBCORNER, f.border);
    }

    @Test
    public void testNonBorderField() throws Exception {
        f = b.board.get(44);
        assertEquals(Border.NONBORDER, f.border);
    }
}