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
        Controller controller = new Controller(width, height);
        Thread game = new Thread(controller);
//        controller.prepareGame();
        game.start();
        try {
            game.join();
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
    }
}
