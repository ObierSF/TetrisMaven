package com.tetris;

/**
 * Created by User on 06.03.2016.
 */
interface ShapeStrategy {
    Tile getTileShape(Board board);
}

class iShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new IShapeTile(board);
    }
}

class oShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new OShapeTile(board);
    }
}

class tShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new TShapeTile(board);
    }
}

class lShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new LShapeTile(board);
    }
}

class jShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new JShapeTile(board);
    }
}

class sShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new SShapeTile(board);
    }
}

class zShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new ZShapeTile(board);
    }
}