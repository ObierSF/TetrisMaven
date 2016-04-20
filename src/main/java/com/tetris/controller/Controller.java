package com.tetris.controller;

import com.tetris.Board;
import com.tetris.tile.move.Move;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by User on 16.04.2016.
 */
public class Controller extends Thread implements Observer {
    private int width;
    private Board board;
    private MoveController moveController;
    private Thread keyThread;
    private KeyController keyController;
    private TileController tileController;
    private ScoreObserver scoreObserver;
    private boolean isGameOver = false;

    public Controller(int width, int height) {
        this.width = width;
        board = new Board(width * height);
    }

    public void prepareGame() {
        tileController = new TileController(width, board);
        scoreObserver = new ScoreObserver(tileController);
        moveController = new MoveController();
        keyController = new KeyController(moveController);
        keyController.addObserver(this);
        keyThread = new Thread(keyController);
    }

    public void run() {
        try {
            if (setNewTile()) {
                keyThread.start();
                gameLoop();
                keyThread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
    }

    private void gameLoop() throws InterruptedException {
        while(!isGameOver) {
            sleep(1000);
            moveController.moveTile(Move.FALL);
            afterMoveUpdate();
        }
    }

    public void update(Observable o, Object arg) {
        afterMoveUpdate();
    }

    private void gameOver() {
        tileController.setLastTile();
        isGameOver = true;
        keyController.setGameOver(true);
        System.out.println("Game Over");
    }

    private void afterMoveUpdate() {
        if (!tileController.isFallPossible()) {
            tilePlaceOperation();
            if (!setNewTile()) {
                gameOver();
            }
        }
    }

    public boolean setNewTile() {
        if (tileController.isAddingTilePossible()) {
            tileController.setRandomTile();
            moveController.setTile(tileController.getTile());
            return true;
        }
        return false;
    }

    private void tilePlaceOperation() {
        tileController.searchForFullRows();
        scoreObserver.sumScore();
        scoreObserver.clearFullRows(board);
        tileController.placeTile();
    }
}
