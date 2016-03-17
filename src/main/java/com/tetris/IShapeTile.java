package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class IShapeTile extends Tile {
    IShapeTile(Board board) {
        super(board);
        color = "RED";
        fields = new ArrayList<Field>();
    }

    @Override
    void setFields() {
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
        fields.add(board.getField(34));
        makeFieldsPartOfTile();
    }

    @Override
    void rotateLeft() {
        rotationLeft();
        if (isRotationPossible()) {
            emptyOldFields();
            if (isNewPositionEmpty()) {
                moveTile();
            }
        }
        makeFieldsPartOfTile();

    }

    void rotationLeft() {
//        if (isVertical())
//            for (int i=0; i< fields.size(); i++)
//                fieldsID[i] = getFieldPosition(1) + ((getFieldPosition(i) - getFieldPosition(1)) / 10);
//        else
//            for (int i=0; i< fields.size(); i++)
//                fieldsID[i] = getFieldPosition(1) - ((getFieldPosition(i) - getFieldPosition(1)) * 10);
    }

    @Override
    void rotateRight() {
        rotationRight();
        if (isRotationPossible()) {
            emptyOldFields();
            if (isNewPositionEmpty()) {
                moveTile();
            }
        }
        makeFieldsPartOfTile();
    }

    void rotationRight() {
//        if (isVertical())
//            for (int i=0; i< fields.size(); i++)
//                fieldsID[i] = getFieldPosition(1) - ((getFieldPosition(i) - getFieldPosition(1)) / 10);
//        else
//            for (int i=0; i< fields.size(); i++)
//                fieldsID[i] = getFieldPosition(1) + ((getFieldPosition(i) - getFieldPosition(1)) * 10);
    }
}