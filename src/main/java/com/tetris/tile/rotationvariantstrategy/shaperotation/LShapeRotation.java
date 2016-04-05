package com.tetris.tile.rotationvariantstrategy.shaperotation;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public enum LShapeRotation implements ShapeRotation {
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
            Field leftNeighbour = getSecond(fields).getLeftNeighbour();
            return leftNeighbour.getLowerNeighbour() != null && !leftNeighbour.isLowerNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, getSecond(fields).getRightNeighbour());
            fields.set(2, getSecond(fields).getLeftNeighbour());
            fields.set(3, fields.get(2).getLowerNeighbour());
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
            Field upperNeighbour = getSecond(fields).getUpperNeighbour();
            return upperNeighbour.getLeftNeighbour() != null && !upperNeighbour.isLeftNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, getSecond(fields).getLowerNeighbour());
            fields.set(2, getSecond(fields).getUpperNeighbour());
            fields.set(3, fields.get(2).getLeftNeighbour());
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
            Field leftNeighbour = getSecond(fields).getLeftNeighbour();
            return leftNeighbour.getUpperNeighbour() != null && !leftNeighbour.isUpperNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, getSecond(fields).getLeftNeighbour());
            fields.set(2, getSecond(fields).getRightNeighbour());
            fields.set(3, fields.get(2).getUpperNeighbour());
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
            Field lowerNeighbour = getSecond(fields).getLowerNeighbour();
            return lowerNeighbour.getRightNeighbour() != null && !lowerNeighbour.isRightNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, getSecond(fields).getUpperNeighbour());
            fields.set(2, getSecond(fields).getLowerNeighbour());
            fields.set(3, fields.get(2).getRightNeighbour());
        }
    };

    Field getSecond(List<Field> fields) {
        return fields.get(1);
    }
}