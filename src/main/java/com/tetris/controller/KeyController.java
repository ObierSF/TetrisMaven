package com.tetris.controller;

import com.tetris.controller.keystrategy.KeyCreator;
import com.tetris.controller.keystrategy.KeyStrategy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by User on 11.04.2016.
 */
public class KeyController implements KeyListener {
    KeyCreator keyCreator;
    MoveController moveController;

    public KeyController(MoveController moveController) {
        this.moveController = moveController;
        keyCreator = new KeyCreator();
    }

    public void keyPressed(KeyEvent e) {
        try {
            KeyStrategy keyStrategy;
            int keyCode = e.getKeyCode();
            keyStrategy = keyCreator.getKey(keyCode);
            keyStrategy.takeAction(moveController);
        } catch (Exception ex) {
            System.out.println("Key exception: " + ex);
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
