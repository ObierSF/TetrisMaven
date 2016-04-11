package com.tetris.controller;

import com.tetris.tile.Tile;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationvariantstrategy.RotationSide;

/**
 * Created by User on 07.04.2016.
 */
public class MoveController {
    Tile tile;

    public MoveController(Tile tile) {
        this.tile = tile;
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

    public void tileFallToBottom() {
        while (tile.move(Move.FALL)) {

        }
    }
}
