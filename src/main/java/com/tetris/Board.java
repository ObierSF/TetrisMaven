package com.tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public class Board {
    private List<Field> board;
    private int length;

    Board(int length) {
        this.length = length;
        board = new ArrayList<Field>(length);
        for(int i=0; i<length; i++) {
            board.add(new Field(i));
        }
        for (Field field : board) {
            field.setSurroundingFields(this);
        }
    }

    Field getField(int fieldNumber) {
        return board.get(fieldNumber);
    }
}