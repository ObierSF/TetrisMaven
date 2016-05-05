package com.tetris.controller;

import com.tetris.Board;
import com.tetris.tile.move.Move;
import com.tetris.view.GameView;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Thread.sleep;

/**
 * Created by User on 16.04.2016.
 */
public class Controller extends JFrame implements Runnable, Observer {
    private static final int fallTime = 1000;
    private int width;
    private int height;
    private BoardController boardController;
    private MoveController moveController;
    private KeyController keyController;
    private TileController tileController;
    private ScoreObserver scoreObserver;
    private GameView gameView;
    private boolean isGameOver = false;

    public Controller(int width, int height) {
        super("Tetris");
        this.width = width;
        this.height = height;
        prepareGame();
    }

    private void prepareGame() {
        boardController = new BoardController(width, height);
        scoreObserver = new ScoreObserver(boardController);
        tileController = new TileController(width, boardController.getBoard());
        moveController = new MoveController();
        gameView = new GameView(boardController.getBoard(), width * height);
        keyController = new KeyController(moveController, gameView);
        moveController.addObserver(this);
        addKeyListener(keyController);
        add(gameView);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public void run() {
        try {
            if (setNewTile()) {
                gameView.repaint();
                gameLoop();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
    }

    private void gameLoop() throws InterruptedException {
        while(!isGameOver) {
            sleep(fallTime);
            moveController.moveTile(Move.FALL);
            afterMoveUpdate();
        }
    }

    private void gameOver() {
        tileController.setLastTile();
        gameView.repaint();
        isGameOver = true;
        System.out.println("Game Over");
    }

    public void update(Observable o, Object arg) {
        afterMoveUpdate();
    }

    private void afterMoveUpdate() {
        gameView.repaint();
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
            gameView.repaint();
            return true;
        }
        return false;
    }

    private void tilePlaceOperation() {
        boardController.searchForFullRows(tileController.getFields());
        scoreObserver.sumScore();
        boardController.clearFullRows(scoreObserver.getRows());
        tileController.placeTile();
    }
}
