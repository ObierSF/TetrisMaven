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

    public void moveTile(Move move) {
        tile.move(move);
    }

    public void rotateTile(RotationSide rotationSide) {
        tile.rotate(rotationSide);
    }

    public void tileFallToBottom() {
        while (tile.move(Move.FALL)) {

        }
    }
}
