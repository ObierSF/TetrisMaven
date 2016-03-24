package com.tetris.ShapeStrategy;

import com.tetris.Board;
import com.tetris.Tile.IShapeTile;
import com.tetris.Tile.Tile;

/**
 * Created by User on 22.03.2016.
 */
public class IShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new IShapeTile(board);
    }
}