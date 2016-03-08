package com.tetris;

import com.tetris.Board;
import com.tetris.Field;
import com.tetris.Move;

import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
abstract class Tile {
    List<Field> fields;
    int[] fieldsID;
    Board board;
    String color;

    Tile(Board board) {
        this.board = board;
    }

    abstract void setFields();
    abstract void rotateLeft();
    abstract void rotateRight();

    void setFieldsOnBoard() {
        for (int i=0; i<fields.size(); i++) {
            fields.get(i).makePartOfTile(color);
            fieldsID[i] = getFieldPosition(i);
        }
    }

    void move(Move move) {
        if (move.isPossible(fieldsID)) {
            move.move(fieldsID);
            emptyOldFields();
            if (isNewPositionEmpty()) {
                moveTile();
            }
            setFieldsOnBoard();
        }
    }

    void emptyOldFields() {
        for (int i=0; i<fields.size(); i++) {
            fields.get(i).empty();
        }
    }

    boolean isNewPositionEmpty() {
        for (int i=0; i<fieldsID.length; i++) {
            if (!board.getField(fieldsID[i]).isEmpty())
                return false;
        }
        return true;
    }

    void moveTile() {
        for (int i=0; i<fieldsID.length; i++) {
            fields.set(i, board.getField(fieldsID[i]));
        }
    }

    boolean isRotationPossible() {
        for (int i=0; i<fields.size(); i++) {
            if (fieldsID[i] < 0 || fieldsID[i] > 159 || fieldsID[i]%10 - fieldsID[1]%10 > 2)
                return false;
        }
        return true;
    }

    int getFieldPosition(int n) {
        return fields.get(n).getPosition();
    }

    boolean isVertical() {
        return Math.abs(fields.get(0).position - fields.get(1).position) == 10;
    }
}