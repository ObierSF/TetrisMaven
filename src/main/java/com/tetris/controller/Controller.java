package com.tetris.controller;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.TileFactory;
import com.tetris.tile.Tile;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by User on 21.03.2016.
 */
public class Controller {
    @Getter private Board board;
    private TileFactory tileFactory;
    @Setter @Getter private Tile tile;

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

    public void placeTile() {
        tile.placeTile();
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
