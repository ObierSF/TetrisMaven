package com.tetris;

/**
 * Created by User on 21.03.2016.
 */
public class Model {
    private Board board;
    private TileFactory tileFactory;
    Tile tile;

    Model(int fieldsNumber) {
        board = new Board(fieldsNumber);
        for (int i=0; i<fieldsNumber; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
        tileFactory = new TileFactory(board);
    }

    void determineRandomTile() {
        tile = tileFactory.returnRandomTile();
    }

    void moveTileLeft() {
        if (tile.isMovePossible(Move.LEFT)) {
            tile.move(Move.LEFT);
        }
    }

    void moveTileRight() {
        if (tile.isMovePossible(Move.RIGHT)) {
            tile.move(Move.RIGHT);
        }
    }

    void tileFall() {
        if (tile.isMovePossible(Move.FALL)) {
            tile.move(Move.FALL);
        }
        else {
            tile.placeTile();
            determineRandomTile();
        }
    }
}
