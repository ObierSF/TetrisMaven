package com.tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public class Board {
    private List<Field> board;
    private int fieldsNumber;

    public Board(int fieldsNumber) {
        this.fieldsNumber = fieldsNumber;
        board = new ArrayList<Field>(fieldsNumber);
        createBoard(fieldsNumber);
        setSurroundingFieldsForFields();
    }

    private void createBoard(int fieldsNumber) {
        for (int i=0; i<fieldsNumber; i++) {
            board.add(new Field(i));
        }
    }

    public Field getField(int fieldPosition) {
        return board.get(fieldPosition);
    }

    public void setSurroundingFieldsForFields() {
        for (Field field : board) {
            field.setSurroundingFields(field.getBorder().determineTheSurroundingFields(this, field.getPosition()));
        }
    }
}