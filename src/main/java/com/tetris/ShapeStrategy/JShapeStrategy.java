package com.tetris.ShapeStrategy;

import com.tetris.Board;
import com.tetris.Tile.JShapeTile;
import com.tetris.Tile.Tile;

/**
 * Created by User on 22.03.2016.
 */
public class JShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new JShapeTile(board);
    }
}
