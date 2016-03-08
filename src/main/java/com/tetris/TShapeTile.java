package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class TShapeTile extends Tile {
    TShapeTile(Board board) {
        super(board);
        color = "YELLOW";
        fields = new ArrayList<Field>(4);
        fieldsID = new int[4];
    }

    @Override
    void setFields() {
        fields.add(board.getField(4));
        fields.add(board.getField(5));
        fields.add(board.getField(6));
        fields.add(board.getField(15));
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {
//        int[] temp = new int[4];
//        rotationLeftPointers(temp);
//        if (isAbleToRotate(temp)) {
//            emptyOldFields();
//            movePointers(temp);
//            setFieldsOnBoard();
//        }
    }

//    void rotationLeftPointers(int[] temp) {
//        if (isVertical()) {
//            temp[0] = fields[3];
//            temp[1] = fields[1];
//            temp[3] = fields[2];
//            temp[2] = fields[1] + ((fields[2] - fields[1]) / 10);
//        }
//        else {
//            temp[0] = fields[3];
//            temp[1] = fields[1];
//            temp[3] = fields[2];
//            temp[2] = fields[1] + ((fields[2] - fields[1]) * -10);
//        }
//    }

    @Override
    void rotateRight() {
//        int[] temp = new int[4];
//        rotationRightPointers(temp);
//        if (isAbleToRotate(temp)) {
//            emptyOldFields();
//            movePointers(temp);
//            setFieldsOnBoard();
//        }
//        rotationRightPointers(temp);
    }

//    void rotationRightPointers(int[] temp) {
//        if (isVertical()) {
//            temp[1] = fields[1];
//            temp[2] = fields[3];
//            temp[3] = fields[0];
//            temp[0] = fields[1] + ((fields[0] - fields[1]) / -10);
//        }
//        else {
//            temp[1] = fields[1];
//            temp[2] = fields[3];
//            temp[3] = fields[0];
//            temp[0] = fields[1] + ((fields[0] - fields[1]) * 10);
//        }
//    }
}