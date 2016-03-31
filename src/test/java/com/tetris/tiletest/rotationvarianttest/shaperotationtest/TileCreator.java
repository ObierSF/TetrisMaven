package com.tetris.tiletest.rotationvarianttest.shaperotationtest;

import com.tetris.Board;
import com.tetris.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 31.03.2016.
 */
public class TileCreator {
    public List<Field> returnTileWithFieldsPositions(int[] positions, Board board) {
        List<Field> tile = new ArrayList<Field>();
        tile.add(board.getField(positions[0]));
        tile.add(board.getField(positions[1]));
        tile.add(board.getField(positions[2]));
        tile.add(board.getField(positions[3]));
        return tile;
    }
}
