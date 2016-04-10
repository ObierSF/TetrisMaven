package com.tetris.controller;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.TileFactory;
import com.tetris.tile.Tile;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import lombok.Getter;

/**
 * Created by User on 21.03.2016.
 */
public class Controller {
    private Board board;
    private TileFactory tileFactory;
    @Getter private Tile tile;

    public Controller(int width, int height) {
        board = new Board(width * height);
        for (int i=0; i<width * height; i++) {
            board.getField(i).setSurroundingFields(board.getField(i).getBorder().determineTheSurroundingFields(board, i));
        }
        tileFactory = new TileFactory(board);
    }

    public void setRandomTile() {
        tile = tileFactory.returnRandomTile();
    }

    public void moveTileLeft() {
        tile.move(Move.LEFT);
    }

    public void moveTileRight() {
        tile.move(Move.RIGHT);
    }

    public void rotateTileLeft() {
        tile.rotate(RotationSide.LEFT);
    }

    public void rotateTileRight() {
        tile.rotate(RotationSide.RIGHT);
    }

    public void tileFall() {
        tile.move(Move.FALL);
    }

    public void placeTile() {
        tile.placeTile();
        tile = null;
    }

    public void clearFullRows() {
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
