package com.tetris.tile.rotationvariantstrategy.shaperotation;

import com.tetris.Field;

import java.util.List;

/**
* Created by User on 22.03.2016.
*/
public enum TShapeRotation implements ShapeRotation {
    HORIZONTALDOWN {
        public boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return getSecond(fields).getRightNeighbour() != null && !getSecond(fields).isRightNeighbourPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return getSecond(fields).getLeftNeighbour() != null && !getSecond(fields).isLeftNeighbourPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            return getSecond(fields).getUpperNeighbour() != null && !getSecond(fields).isUpperNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, getSecond(fields).getRightNeighbour());
            fields.set(2, getSecond(fields).getLeftNeighbour());
            fields.set(3, getSecond(fields).getUpperNeighbour());
        }
    },
    VERTICALDOWN {
        public boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return getSecond(fields).getLowerNeighbour() != null && !getSecond(fields).isLowerNeighbourPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return getSecond(fields).getUpperNeighbour() != null && !getSecond(fields).isUpperNeighbourPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            return getSecond(fields).getRightNeighbour() != null && !getSecond(fields).isRightNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, getSecond(fields).getLowerNeighbour());
            fields.set(2, getSecond(fields).getUpperNeighbour());
            fields.set(3, getSecond(fields).getRightNeighbour());
        }
    },
    HORIZONTALUP {
        public boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return getSecond(fields).getLeftNeighbour() != null && !getSecond(fields).isLeftNeighbourPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return getSecond(fields).getRightNeighbour() != null && !getSecond(fields).isRightNeighbourPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            return getSecond(fields).getRightNeighbour() != null && !getSecond(fields).isRightNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, getSecond(fields).getLeftNeighbour());
            fields.set(2, getSecond(fields).getRightNeighbour());
            fields.set(3, getSecond(fields).getLowerNeighbour());
        }
    },
    VERTICALUP {
        public boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return getSecond(fields).getUpperNeighbour() != null && !getSecond(fields).isUpperNeighbourPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return getSecond(fields).getLowerNeighbour() != null && !getSecond(fields).isLowerNeighbourPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            return getSecond(fields).getLeftNeighbour() != null && !fields.get(2).isLeftNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, getSecond(fields).getUpperNeighbour());
            fields.set(2, getSecond(fields).getLowerNeighbour());
            fields.set(3, getSecond(fields).getLeftNeighbour());
        }
    };

    Field getSecond(List<Field> fields) {
        return fields.get(1);
    }
}
