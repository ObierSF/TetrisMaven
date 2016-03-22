package com.tetris;

/**
 * Created by User on 22.03.2016.
 */
public class ZShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new ZShapeTile(board);
    }
}
