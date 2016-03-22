package com.tetris;

/**
 * Created by User on 06.03.2016.
 */
interface ShapeStrategy {
    Tile getTileShape(Board board);
}