package com.tetris.controller;

import com.tetris.Board;
import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import lombok.Getter;

import java.util.List;
import java.util.Observable;

/**
 * Created by User on 20.04.2016.
 */
public class BoardController extends Observable {
    private int width;
    private int height;
    @Getter private Board board;

    BoardController(int width, int height) {
        this.width = width;
        this.height = height;
        board = new Board(width * height);
    }

    public void searchForFullRows(List<Field> fields) {
        for (Field field : fields) {
            if (field.isSideOfRowFull(Neighbour.LEFT) && field.isSideOfRowFull(Neighbour.RIGHT)) {
                setChanged();
                notifyObservers(field.getPosition());
            }
        }
    }

    public void clearFullRows(List<Integer> rows) {
        for (Integer row : rows) {
            board.getField(row * width).clearRow();
            clearRow(row);
        }
        rows.clear();
    }

    public void clearRow(int rowNumber) {
        int row = (rowNumber-1) * width;
        for (int i=0; i<width; i++) {
            System.out.print("Clear: "+ (i+row) + " " );
            board.getField(i+row).columnFall();
        }
        System.out.println();
    }
}
