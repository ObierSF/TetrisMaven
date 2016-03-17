package com.tetris;

import java.util.List;

/**
 * Created by User on 07.03.2016.
 */
public enum Move {
    FALL {
        @Override
        boolean isPossible(List<Field> fields) {
            for (Field field : fields) {
                if (field.getSurroundingFields().lower == null || field.getSurroundingFields().lower.isPlacedField() == true) {
                    return false;
                }
            }
            return true;
        }

        @Override
        void move(List<Field> fields) {
            for (Field field : fields) {
//                field = field.getSurroundingFields().lower;
            }
        }
    },
    LEFT {
        @Override
        boolean isPossible(List<Field> fields) {
            for (Field field : fields) {
                if (field.getSurroundingFields().left == null || field.getSurroundingFields().left.isPlacedField() == true) {
                    return false;
                }
            }
            return true;
        }

        @Override
        void move(List<Field> fields) {
            for (Field field : fields) {
//                field = field.getSurroundingFields().left;
            }
        }
    },
    RIGHT {
        @Override
        boolean isPossible(List<Field> fields) {
            for (Field field : fields) {
                if (field.getSurroundingFields().right == null || field.getSurroundingFields().right.isPlacedField() == true) {
                    return false;
                }
            }
            return true;
        }

        @Override
        void move(List<Field> fields) {
            for (Field field : fields) {
//                field = field.getSurroundingFields().right;
            }
        }
    };

    final int width = 10;
    abstract boolean isPossible(List<Field> fields);
    abstract void move(List<Field> fields);
}
