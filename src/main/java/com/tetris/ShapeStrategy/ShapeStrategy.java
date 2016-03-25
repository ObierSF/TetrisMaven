package com.tetris.ShapeStrategy;

import com.tetris.Board;
import com.tetris.Tile.Tile;

/**
 * Created by User on 06.03.2016.
 */
public interface ShapeStrategy {
    Tile getTileShape(Board board);
}