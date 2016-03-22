package com.tetris;

import java.util.List;

/**
* Created by User on 22.03.2016.
*/
public enum TShapeRotation {
    HORIZONTALDOWN {
        @Override
        boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().upper != null && !fields.get(1).getSurroundingFields().upper.isPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().left != null && !fields.get(1).getSurroundingFields().left.isPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().lower != null && !fields.get(1).getSurroundingFields().lower.isPlacedField();
        }

        @Override
        void rotate(List<Field> fields) {
            fields.set(0, fields.get(1).getSurroundingFields().upper);
            fields.set(2, fields.get(1).getSurroundingFields().left);
            fields.set(3, fields.get(1).getSurroundingFields().lower);
        }
    },
    VERTICALDOWN {
        @Override
        boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().right != null && !fields.get(1).getSurroundingFields().right.isPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().left != null && !fields.get(1).getSurroundingFields().left.isPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().upper != null && !fields.get(1).getSurroundingFields().upper.isPlacedField();
        }

        @Override
        void rotate(List<Field> fields) {
            fields.set(0, fields.get(1).getSurroundingFields().right);
            fields.set(2, fields.get(1).getSurroundingFields().left);
            fields.set(3, fields.get(1).getSurroundingFields().upper);
        }
    },
    HORIZONTALUP {
        @Override
        boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().upper != null && !fields.get(1).getSurroundingFields().upper.isPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().lower != null && !fields.get(1).getSurroundingFields().lower.isPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().right != null && !fields.get(2).getSurroundingFields().right.isPlacedField();
        }

        @Override
        void rotate(List<Field> fields) {
            fields.set(0, fields.get(1).getSurroundingFields().upper);
            fields.set(2, fields.get(1).getSurroundingFields().lower);
            fields.set(3, fields.get(1).getSurroundingFields().right);
        }
    },
    VERTICALUP {
        @Override
        boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().left != null && !fields.get(1).getSurroundingFields().left.isPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().right != null && !fields.get(1).getSurroundingFields().right.isPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            return fields.get(1).getSurroundingFields().right != null && !fields.get(1).getSurroundingFields().right.isPlacedField();
        }

        @Override
        void rotate(List<Field> fields) {
            fields.set(0, fields.get(1).getSurroundingFields().left);
            fields.set(2, fields.get(1).getSurroundingFields().right);
            fields.set(3, fields.get(1).getSurroundingFields().lower);
        }
    };

    abstract boolean isPossible(List<Field> fields);
    abstract void rotate(List<Field> fields);
}