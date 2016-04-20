package com.tetris.tile;

import com.tetris.Board;
import com.tetris.field.Field;
import com.tetris.tile.move.Move;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 09.03.2016.
 */
public class TileTest {
    private final int width = 10;
    private Board board;

    @Before
    public void setUp() throws Exception {
        int fieldsNumber = 160;
        board = new Board(fieldsNumber);
    }

    @Test
    public void shouldReturnTrueIfTileCanBeAdded() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        boolean answer;
        //when
        answer = pseudoRandomTile.isAddingPossible();
        //then
        assertTrue(answer);
    }

    @Test
    public void shouldReturnFalseIfTileCantBeAdded() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        pseudoRandomTile.placeTile();
        pseudoRandomTile = new IShapeTile(board);
        boolean answer;
        //when
        answer = pseudoRandomTile.isAddingPossible();
        //then
        assertFalse(answer);
    }

    @Test
    public void shouldMoveUpIfPlaceIsOccupied() throws Exception {
        //given
        boolean answer;
        List<Field> fields;
        int lastFieldOnBoardPosition = 4;
        Tile pseudoRandomTile = new IShapeTile(board);
        pseudoRandomTile.move(Move.FALL);
        pseudoRandomTile.placeTile();
        pseudoRandomTile = new IShapeTile(board);
        fields = pseudoRandomTile.getFields();
        //when
        if (answer = !pseudoRandomTile.isAddingPossible()) {
            pseudoRandomTile.moveLastTileUp();
        }
        //then
        assertNull(fields.get(0));
        assertNull(fields.get(1));
        assertNull(fields.get(2));
        assertEquals(lastFieldOnBoardPosition, fields.get(3).getPosition());
        assertTrue(answer);
    }

    @Test
    public void tileShouldBeOverTheBoard() throws Exception {
        //given
        boolean answer;
        List<Field> fields;
        Tile pseudoRandomTile = new IShapeTile(board);
        pseudoRandomTile.placeTile();
        pseudoRandomTile = new IShapeTile(board);
        fields = pseudoRandomTile.getFields();
        //when
        if (answer = !pseudoRandomTile.isAddingPossible()) {
            pseudoRandomTile.moveLastTileUp();
        }
        //then
        for (Field field : fields) {
            assertNull(field);
        }
        assertTrue(answer);
    }

    @Test
    public void shouldNotFallBelowBottom() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] bottomPosition = {124, 134, 144, 154};
        int numberOfMovesTillBottom = 12;
        //when
        for (int i=0; i<numberOfMovesTillBottom; i++) {
            pseudoRandomTile.move(Move.FALL);
        }
        //then
        for (int i=0; i<bottomPosition.length; i++) {
            assertEquals(bottomPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        pseudoRandomTile.move(Move.FALL);
        //then
        for (int i=0; i<bottomPosition.length; i++) {
            assertEquals(bottomPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldStopMovingWhenRightBorderIsReached() throws Exception {
        //given
        Tile pseudoRandomTile = new OShapeTile(board);
        int[] extremeRightPosition = {8, 9, 18, 19};
        int numberOfMovesTillRightBorder = 4;
        //when
        for (int i=0; i<numberOfMovesTillRightBorder; i++) {
            pseudoRandomTile.move(Move.RIGHT);
        }
        //then
        for (int i=0; i<extremeRightPosition.length; i++) {
            assertEquals(extremeRightPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        pseudoRandomTile.move(Move.RIGHT);
        //then
        for (int i=0; i<extremeRightPosition.length; i++) {
            assertEquals(extremeRightPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldStopMovingWhenLeftBorderIsReached() throws Exception {
        //given
        Tile pseudoRandomTile = new OShapeTile(board);
        int[] extremeLeftPosition = {0, 1, 10, 11};
        int numberOfMovesTillLeftBorder = 4;
        //when
        for (int i=0; i<numberOfMovesTillLeftBorder; i++) {
            pseudoRandomTile.move(Move.LEFT);
        }
        //then
        for (int i=0; i<extremeLeftPosition.length; i++) {
            assertEquals(extremeLeftPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
        //and when
        pseudoRandomTile.move(Move.LEFT);
        //then
        for (int i=0; i<extremeLeftPosition.length; i++) {
            assertEquals(extremeLeftPosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldNotFallWhenFieldBelowIsNotEmpty() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] tilePosition = {4, 14, 24, 34};
        int belowFieldPosition = 44;
        //when
        board.getField(belowFieldPosition).placeField();
        pseudoRandomTile.move(Move.FALL);
        //then
        for (int i=0; i<tilePosition.length; i++) {
            assertEquals(tilePosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldNotMoveLeftWhenFieldIsNotAvailable() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] tilePosition = {4, 14, 24, 34};
        int placedLeftFieldPosition = 13;
        //when
        board.getField(placedLeftFieldPosition).placeField();
        pseudoRandomTile.move(Move.LEFT);
        //then
        for (int i=0; i<tilePosition.length; i++) {
            assertEquals(tilePosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }

    @Test
    public void shouldNotMoveRightWhenFieldIsNotAvailable() throws Exception {
        //given
        Tile pseudoRandomTile = new IShapeTile(board);
        int[] tilePosition = {4, 14, 24, 34};
        int placedRightFieldPosition = 35;
        //when
        board.getField(placedRightFieldPosition).placeField();
        pseudoRandomTile.move(Move.RIGHT);
        //then
        for (int i=0; i<tilePosition.length; i++) {
            assertEquals(tilePosition[i], pseudoRandomTile.getFieldPosition(i));
        }
    }
}