package com.tetris.ShapeStrategy;

import com.tetris.Board;
import com.tetris.Tile.Tile;
import com.tetris.Tile.ZShapeTile;

/**
 * Created by User on 22.03.2016.
 */
public class ZShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new ZShapeTile(board);
    }
}
