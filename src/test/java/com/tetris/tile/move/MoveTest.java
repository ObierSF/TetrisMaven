package com.tetris.tile.move;

import com.tetris.Board;
import com.tetris.field.Field;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 17.03.2016.
 */
public class MoveTest {
    private final int width = 10;
    private MoveStrategy moveStrategy;
    private Board board;
    private int[] iShapeTilePositions;
    private List<Field> pseudoRandomTile;
    private Color color;

    @Before
    public void setUp() {
        int fieldsNumber = 160;
        board = new Board(fieldsNumber);
        //given
        iShapeTilePositions = new int[]{4, 14, 24, 34};
        pseudoRandomTile = new ArrayList<Field>();
        for (int iShapeTilePosition : iShapeTilePositions) {
            pseudoRandomTile.add(board.getField(iShapeTilePosition));
        }
        color = Color.RED;
    }

    private boolean move(MoveStrategy moveStrategy) {
        if (moveStrategy.isPossible(pseudoRandomTile)) {
            moveStrategy.move(pseudoRandomTile);
            return true;
        }
        return false;
    }

    @Test
    public void tileShouldMoveUp() throws Exception {
        //given
        tileShouldFall();
        moveStrategy = new UpStrategy();
        //when
        assertTrue(move(moveStrategy));
        //then
        int i = 0;
        for (Field field : pseudoRandomTile) {
            assertEquals(iShapeTilePositions[i], field.getPosition());
            i++;
        }
    }

    @Test
    public void tileShouldFall() throws Exception {
        //given
        moveStrategy = new FallStrategy();
        //when
        move(moveStrategy);
        //then
        int i = 0;
        for (Field field : pseudoRandomTile) {
            assertEquals(iShapeTilePositions[i] + width, field.getPosition());
            i++;
        }
        assertTrue(board.getField(iShapeTilePositions[0]).isEmpty());
    }

    @Test
    public void tileShouldMoveLeft() throws Exception {
        //given
        moveStrategy = new LeftStrategy();
        //when
        move(moveStrategy);
        //then
        int i = 0;
        for (Field field : pseudoRandomTile) {
            assertEquals(iShapeTilePositions[i] - 1, field.getPosition());
            assertTrue(board.getField(iShapeTilePositions[i]).isEmpty());
            i++;
        }
    }

    @Test
    public void tileShouldMoveRight() throws Exception {
        //given
        moveStrategy = new RightStrategy();
        //when
        move(moveStrategy);
        //then
        int i = 0;
        for (Field field : pseudoRandomTile) {
            assertEquals(iShapeTilePositions[i] + 1, field.getPosition());
            assertTrue(board.getField(iShapeTilePositions[i]).isEmpty());
            i++;
        }
    }

    @Test
    public void tileShouldNotMoveUpOverBoard() throws Exception {
        //given
        boolean moveAnswer;
        moveStrategy = new UpStrategy();
        //when
        moveAnswer = move(moveStrategy);
        //then
        assertFalse(moveAnswer);
    }

    @Test
    public void shouldNotFallWhenFieldIsNotAvailable() throws Exception {
        //given
        moveStrategy = new FallStrategy();
        int belowFieldPosition = 44;
        board.getField(belowFieldPosition).placeField(color);
        boolean moveResponse;
        //when
        moveResponse = move(moveStrategy);
        //then
        assertFalse(moveResponse);
    }

    @Test
    public void shouldNotMoveLeftWhenFieldIsNotAvailable() throws Exception {
        //given
        moveStrategy = new LeftStrategy();
        int placedLeftFieldPosition = 23;
        board.getField(placedLeftFieldPosition).placeField(color);
        boolean moveResponse;
        //when
        moveResponse = move(moveStrategy);
        //then
        assertFalse(moveResponse);
    }

    @Test
    public void shouldNotMoveRightWhenFieldIsNotAvailable() throws Exception {
        //given
        moveStrategy = new RightStrategy();
        int placedRightFieldPosition = 15;
        board.getField(placedRightFieldPosition).placeField(color);
        boolean moveResponse;
        //when
        moveResponse = move(moveStrategy);
        //then
        assertFalse(moveResponse);
    }

    @Test
    public void tileShouldMoveOverBoard() {
        //given
        moveStrategy = new UpStrategy();
        //when
        moveStrategy.lastMove(pseudoRandomTile);
        //then
        assertNull(pseudoRandomTile.get(0));
        assertEquals(iShapeTilePositions[0], pseudoRandomTile.get(1).getPosition());
        assertEquals(iShapeTilePositions[1], pseudoRandomTile.get(2).getPosition());
        assertEquals(iShapeTilePositions[2], pseudoRandomTile.get(3).getPosition());
        //when
        moveStrategy.lastMove(pseudoRandomTile);
        //then
        assertNull(pseudoRandomTile.get(0));
        assertNull(pseudoRandomTile.get(1));
        assertEquals(iShapeTilePositions[0], pseudoRandomTile.get(2).getPosition());
        assertEquals(iShapeTilePositions[1], pseudoRandomTile.get(3).getPosition());
        //when
        moveStrategy.lastMove(pseudoRandomTile);
        //then
        assertNull(pseudoRandomTile.get(0));
        assertNull(pseudoRandomTile.get(1));
        assertNull(pseudoRandomTile.get(2));
        assertEquals(iShapeTilePositions[0], pseudoRandomTile.get(3).getPosition());
        //when
        moveStrategy.lastMove(pseudoRandomTile);
        //then
        assertNull(pseudoRandomTile.get(0));
        assertNull(pseudoRandomTile.get(1));
        assertNull(pseudoRandomTile.get(2));
        assertNull(pseudoRandomTile.get(3));
    }
}