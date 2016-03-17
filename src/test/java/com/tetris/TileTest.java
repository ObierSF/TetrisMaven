package com.tetris;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 09.03.2016.
 */
public class TileTest {
    Board b;
    Tile t;

    @Before
    public void setUp() throws Exception {
        b = new Board(160);
    }

    @Test
    public void testSetFieldsOnBoard() throws Exception {
        t = new JShapeTile(b);
        t.setFields();
//        assertTrue(t.fields.get(0).partOfTile);
//        assertTrue(t.fields.get(1).partOfTile);
//        assertTrue(t.fields.get(2).partOfTile);
//        assertTrue(t.fields.get(3).partOfTile);
    }

    @Test
    public void testEmptyOldFields() throws Exception {
        t = new IShapeTile(b);
        t.setFields();
//        assertTrue(t.fields.get(0).partOfTile);
//        t.emptyOldFields();
//        assertFalse(t.fields.get(0).partOfTile);
    }

    @Test
    public void testIsVertical() throws Exception {
        t = new IShapeTile(b);
        t.setFields();
        assertTrue(t.isVertical());
    }

    @Test
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

    @Test
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

    @Test
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