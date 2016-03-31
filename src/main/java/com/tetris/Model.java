package com.tetris;

import com.tetris.tile.Tile;
import com.tetris.tile.rotationvariantstrategy.RotationSide;

/**
 * Created by User on 21.03.2016.
 */
public class Model {
    private Board board;
    private TileFactory tileFactory;
    Tile tile;

    Model(int width, int height) {
        board = new Board(width * height);
        for (int i=0; i<width * height; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
        tileFactory = new TileFactory(board);
    }

    void setRandomTile() {
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

    void rotateTileLeft() {
        tile.rotate(RotationSide.LEFT);
    }

    void rotateTileRight() {
        tile.rotate(RotationSide.RIGHT);
    }

    boolean canTileFall() {
        return tile.isMovePossible(Move.FALL);
    }

    void tileFall() {
        tile.move(Move.FALL);
    }

    void placeTile() {
        tile.placeTile();
    }

    void clearFullRows() {
        Field temporaryField;
        for (Field field : tile.getFields()) {
            temporaryField = field.getSurroundingFields().right;
            while (temporaryField != null || temporaryField.isPartOfTile()) {
                temporaryField = temporaryField.getSurroundingFields().right;
                if (temporaryField.isPlacedField()) {

                }
            }
            temporaryField = field.getSurroundingFields().left;
            while (temporaryField != null || temporaryField.isPartOfTile()) {
                temporaryField = temporaryField.getSurroundingFields().left;
                if (temporaryField.isPlacedField()) {

                }
            }
        }
    }
}
