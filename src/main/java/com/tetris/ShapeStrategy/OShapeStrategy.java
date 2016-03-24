package com.tetris.ShapeStrategy;

import com.tetris.Board;
import com.tetris.Tile.OShapeTile;
import com.tetris.Tile.Tile;

/**
 * Created by User on 22.03.2016.
 */
public class OShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new OShapeTile(board);
    }
}
