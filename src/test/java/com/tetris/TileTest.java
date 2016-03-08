package com.tetris;

import junit.framework.TestCase;

/**
 * Created by User on 07.03.2016.
 */
public class TileTest extends TestCase {
    Board b;
    Tile t;

    public void setUp() throws Exception {
        super.setUp();
        b = new Board(160);
    }

    public void testSetFieldsOnBoard() throws Exception {
        t = new JShapeTile(b);
        t.setFields();
        assertTrue(t.fields.get(0).isPartOfTile);
        assertTrue(t.fields.get(1).isPartOfTile);
        assertTrue(t.fields.get(2).isPartOfTile);
        assertTrue(t.fields.get(3).isPartOfTile);
    }

    public void testEmptyOldFields() throws Exception {
        t = new IShapeTile(b);
        t.setFields();
        assertTrue(t.fields.get(0).isPartOfTile);
        t.emptyOldFields();
        assertFalse(t.fields.get(0).isPartOfTile);
    }

    public void testIsVertical() throws Exception {
        t = new IShapeTile(b);
        t.setFields();
        assertTrue(t.isVertical());
    }

    public void testFallBelowBottom() throws Exception {
        t = new IShapeTile(b);
        t.setFields();
        for (int i=0; i<12; i++)
            t.move(Move.FALL);
        assertEquals(124, t.getFieldPosition(0));
        assertEquals(134, t.getFieldPosition(1));
        assertEquals(144, t.getFieldPosition(2));
        assertEquals(154, t.getFieldPosition(3));
        t.move(Move.FALL);
        assertEquals(124, t.getFieldPosition(0));
        assertEquals(134, t.getFieldPosition(1));
        assertEquals(144, t.getFieldPosition(2));
        assertEquals(154, t.getFieldPosition(3));
    }

    public void testMoveRightToBorder() throws Exception {
        t = new OShapeTile(b);
        t.setFields();
        for (int i=0; i<4; i++)
            t.move(Move.RIGHT);
        assertEquals(8, t.getFieldPosition(0));
        assertEquals(9, t.getFieldPosition(1));
        assertEquals(18, t.getFieldPosition(2));
        assertEquals(19, t.getFieldPosition(3));
        t.move(Move.RIGHT);
        assertEquals(8, t.getFieldPosition(0));
        assertEquals(9, t.getFieldPosition(1));
        assertEquals(18, t.getFieldPosition(2));
        assertEquals(19, t.getFieldPosition(3));
    }

    public void testMoveLeftToBorder() throws Exception {
        t = new OShapeTile(b);
        t.setFields();
        for (int i=0; i<4; i++)
            t.move(Move.LEFT);
        assertEquals(0, t.getFieldPosition(0));
        assertEquals(1, t.getFieldPosition(1));
        assertEquals(10, t.getFieldPosition(2));
        assertEquals(11, t.getFieldPosition(3));
        t.move(Move.LEFT);
        assertEquals(0, t.getFieldPosition(0));
        assertEquals(1, t.getFieldPosition(1));
        assertEquals(10, t.getFieldPosition(2));
        assertEquals(11, t.getFieldPosition(3));
    }
}