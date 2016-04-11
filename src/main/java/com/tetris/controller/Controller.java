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
        tileFactory = new TileFactory(board);
    }

    public void setRandomTile() {
        tile = tileFactory.returnRandomTile();
    }

    public void placeTile() {
        tile.placeTile();
    }

    public void clearFullRows() {

    }
}
