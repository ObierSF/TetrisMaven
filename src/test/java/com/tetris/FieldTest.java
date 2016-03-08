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
    }

    public void testMakePartOfTile() throws Exception {
        f.makePartOfTile("RED");
        assertTrue(f.isPartOfTile);
        assertFalse(f.isLocated);
        assertEquals(f.color, "RED");
    }

    public void testEmpty() throws Exception {
        f.empty();
        assertFalse(f.isPartOfTile);
        assertFalse(f.isLocated);
    }
}