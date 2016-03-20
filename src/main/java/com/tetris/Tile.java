package com.tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
abstract class Tile {
    protected List<Field> fields;
    protected Board board;
    protected String color;

    Tile(Board board) {
        this.board = board;
    }

    abstract void rotateLeft();
    abstract void rotateRight();

    void setUpFields(int[] shapePosition) {
        fields = new ArrayList<Field>();
        for (int i : shapePosition) {
            fields.add(board.getField(i));
        }
        makeFieldsPartOfTile();
    }

    void makeFieldsPartOfTile() {
        for (Field field : fields) {
            field.makePartOfTile(color);
        }
    }

    boolean isMovePossible(Move move) {
        return move.isPossible(fields);
    }

    void move(Move move) {
        move.move(fields, color);
    }

    void placeTile() {
        for (Field field : fields) {
            field.placeField();
        }
    }

    int getFieldPosition(int n) {
        return fields.get(n).getPosition();
    }

    boolean isVertical() {
        return Math.abs(getFieldPosition(0) - getFieldPosition(1)) == 10;
    }

    boolean isUpSideDown() {
        return getFieldPosition(0) > getFieldPosition(1);
    }
}