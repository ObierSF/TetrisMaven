package com.tetris;

import com.tetris.controller.Controller;

import java.util.Observable;
import java.util.Observer;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        int width = 10;
        int height = 16;
        Controller game = new Controller(width, height);
        game.prepareGame();
        game.start();
        try {
            game.join();
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
    }
}
