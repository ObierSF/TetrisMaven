package com.tetris.controller;

import com.tetris.controller.keystrategy.KeyCreator;
import com.tetris.controller.keystrategy.KeyStrategy;
import com.tetris.view.GameView;
import lombok.Setter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import static java.lang.Thread.sleep;

/**
 * Created by User on 11.04.2016.
 */
public class KeyController implements KeyListener {
    private GameView gameView;
    private KeyCreator keyCreator;
    private MoveController moveController;

    public KeyController(MoveController moveController, GameView gameView) {
        this.moveController = moveController;
        this.gameView = gameView;
        keyCreator = new KeyCreator();
    }

    public void keyPressed(KeyEvent keyEvent) {
        try {
            KeyStrategy keyStrategy;
            int keyCode = keyEvent.getKeyCode();
            keyStrategy = keyCreator.getKey(keyCode);
            keyStrategy.takeAction(moveController);
            //gameView.repaint();
        } catch (Exception e) {
            System.out.println("Key exception: " + e);
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
