package com.tetris.ShapeStrategy;

import com.tetris.Board;
import com.tetris.Tile.TShapeTile;
import com.tetris.Tile.Tile;

/**
 * Created by User on 22.03.2016.
 */
public class TShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new TShapeTile(board);
    }
}
