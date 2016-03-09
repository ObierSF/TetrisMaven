package com.tetris;

import junit.framework.TestCase;

/**
 * Created by User on 06.03.2016.
 */
public class FieldTest extends TestCase {
    Field f;
    Board b;

    public void setUp() throws Exception {
        super.setUp();
        b = new Board(160);
        f = b.board.get(4);
    }

    public void testLocate() throws Exception {
        f.locate();
        assertFalse(f.isPartOfTile);
        assertTrue(f.isLocated);
        assertFalse(f.isEmpty());
    }

    public void testMakePartOfTile() throws Exception {
        f.makePartOfTile("RED");
        assertTrue(f.isPartOfTile);
        assertFalse(f.isLocated);
        assertEquals(f.color, "RED");
        assertFalse(f.isEmpty());
    }

    public void testEmpty() throws Exception {
        f.empty();
        assertFalse(f.isPartOfTile);
        assertFalse(f.isLocated);
        assertTrue(f.isEmpty());
    }

    public void testLeftBorderField() throws Exception {
        f = b.board.get(20);
        assertEquals(Border.LEFT, f.border);
    }

    public void testRightBorderField() throws Exception {
        f = b.board.get(59);
        assertEquals(Border.RIGHT, f.border);
    }

    public void testTopBorderField() throws Exception {
        f = b.board.get(4);
        assertEquals(Border.TOP, f.border);
    }

    public void testBottomBorderField() throws Exception {
        f = b.board.get(158);
        assertEquals(Border.BOTTOM, f.border);
    }

    public void testLTCornerBorderField() throws Exception {
        f = b.board.get(0);
        assertEquals(Border.LTCORNER, f.border);
    }

    public void testRTCornerBorderField() throws Exception {
        f = b.board.get(9);
        assertEquals(Border.RTCORNER, f.border);
    }

    public void testLBCornerBorderField() throws Exception {
        f = b.board.get(150);
        assertEquals(Border.LBCORNER, f.border);
    }

    public void testRBCornerBorderField() throws Exception {
        f = b.board.get(159);
        assertEquals(Border.RBCORNER, f.border);
    }

    public void testNonBorderField() throws Exception {
        f = b.board.get(44);
        assertEquals(Border.NONBORDER, f.border);
    }
}