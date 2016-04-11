package com.tetris.controller.keystrategy;

import com.tetris.controller.MoveController;

import java.awt.event.KeyEvent;

/**
 * Created by User on 11.04.2016.
 */
public class DownArrowStrategy implements KeyStrategy {
    public boolean validate(int pressedKey) {
        return pressedKey == KeyEvent.VK_DOWN;
    }

    public void takeAction(MoveController moveController) {
        moveController.moveTileRight();
    }
}
