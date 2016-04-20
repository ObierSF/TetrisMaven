package com.tetris.controller;

import com.tetris.controller.keystrategy.KeyCreator;
import com.tetris.controller.keystrategy.KeyStrategy;
import lombok.Setter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import static java.lang.Thread.sleep;

/**
 * Created by User on 11.04.2016.
 */
public class KeyController extends Observable implements KeyListener, Runnable {
    private KeyCreator keyCreator;
    private MoveController moveController;
    @Setter private boolean isGameOver = false;

    public KeyController(MoveController moveController) {
        this.moveController = moveController;
        keyCreator = new KeyCreator();
    }

    public void run() {
        while(!isGameOver){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        try {
            KeyStrategy keyStrategy;
            int keyCode = e.getKeyCode();
            keyStrategy = keyCreator.getKey(keyCode);
            keyStrategy.takeAction(moveController);
            setChanged();
            notifyObservers();
        } catch (Exception ex) {
            System.out.println("Key exception: " + ex);
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
