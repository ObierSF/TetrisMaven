package com.tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public class Board {
    private List<Field> board;
    private int fieldsNumber;

    Board(int fieldsNumber) {
        this.fieldsNumber = fieldsNumber;
        board = new ArrayList<Field>(fieldsNumber);
        for (int i=0; i<fieldsNumber; i++) {
            board.add(new Field(i));
        }
    }

    Field getField(int fieldPosition) {
        return board.get(fieldPosition);
    }
}