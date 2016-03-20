package com.tetris;

/**
 * Created by User on 06.03.2016.
 */
public class TShapeTile extends Tile {
    TShapeTile(Board board) {
        super(board);
        color = "YELLOW";
        int[] iShapePosition = {4, 5, 6, 15};
        setUpFields(iShapePosition);
    }

    @Override
    void rotateLeft() {
//        int[] temp = new int[4];
//        rotationLeftPointers(temp);
//        if (isAbleToRotate(temp)) {
//            emptyOldFields();
//            movePointers(temp);
//            makeFieldsPartOfTile();
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
//            makeFieldsPartOfTile();
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