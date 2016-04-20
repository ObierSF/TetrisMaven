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
    private GameController gameController;
    private ScoreObserver scoreObserver;
    private boolean isGameOver = false;

    public Controller(int width, int height) {
        this.width = width;
        board = new Board(width * height);
    }

    public void prepareGame() {
        gameController = new GameController(width, board);
        scoreObserver = new ScoreObserver(gameController);
        moveController = new MoveController();
        keyController = new KeyController(moveController);
        keyController.addObserver(this);
        keyThread = new Thread(keyController);
    }

    public void run() {
        try {
            if (gameController.isAddingTilePossible()) {
                gameController.setRandomTile();
                moveController.setTile(gameController.getTile());
                keyThread.start();
                while(!isGameOver) {
                    sleep(1000);
                    moveController.moveTile(Move.FALL);
                    afterMoveUpdate();
                }
                keyThread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
    }

    public void update(Observable o, Object arg) {
        afterMoveUpdate();
    }

    private void gameOver() {
        System.out.println("Game Over");
        isGameOver = true;
        keyController.setGameOver(true);
    }

    private void afterMoveUpdate() {
        if (!gameController.isFallPossible()) {
            gameController.searchForFullRows();
            scoreObserver.sumScore();
            scoreObserver.clearFullRows(board);
            gameController.placeTile();
            if (!gameController.isAddingTilePossible()) {
                gameController.setLastTile();
                gameOver();
            }
            else {
                gameController.setRandomTile();
                moveController.setTile(gameController.getTile());
            }
        }
    }
}
