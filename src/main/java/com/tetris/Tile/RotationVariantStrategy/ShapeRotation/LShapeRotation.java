package com.tetris.Tile.RotationVariantStrategy.ShapeRotation;

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
            return fields.get(1).getRightNeighbour() != null && !fields.get(1).isRightNeighbourPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return fields.get(1).getLeftNeighbour() != null && !fields.get(1).isLeftNeighbourPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            Field leftNeighbour = fields.get(1).getLeftNeighbour();
            return leftNeighbour.getLowerNeighbour() != null && !leftNeighbour.isLowerNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, fields.get(1).getRightNeighbour());
            fields.set(2, fields.get(1).getLeftNeighbour());
            fields.set(3, fields.get(2).getLowerNeighbour());
        }
    },
    VERTICALDOWN {
        public boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return fields.get(1).getLowerNeighbour() != null && !fields.get(1).isLowerNeighbourPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return fields.get(1).getUpperNeighbour() != null && !fields.get(1).isUpperNeighbourPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            Field upperNeighbour = fields.get(1).getUpperNeighbour();
            return upperNeighbour.getLeftNeighbour() != null && !upperNeighbour.isLeftNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, fields.get(1).getLowerNeighbour());
            fields.set(2, fields.get(1).getUpperNeighbour());
            fields.set(3, fields.get(2).getLeftNeighbour());
        }
    },
    HORIZONTALUP {
        public boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return fields.get(1).getLeftNeighbour() != null && !fields.get(1).isLeftNeighbourPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return fields.get(1).getRightNeighbour() != null && !fields.get(1).isRightNeighbourPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            Field leftNeighbour = fields.get(1).getLeftNeighbour();
            return leftNeighbour.getUpperNeighbour() != null && !leftNeighbour.isUpperNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, fields.get(1).getLeftNeighbour());
            fields.set(2, fields.get(1).getRightNeighbour());
            fields.set(3, fields.get(2).getUpperNeighbour());
        }
    },
    VERTICALUP {
        public boolean isPossible(List<Field> fields) {
            return isFirstPositionAvailable(fields) && isThrirdPositionAvailable(fields) && isForthPositionAvailable(fields);
        }

        private boolean isFirstPositionAvailable(List<Field> fields) {
            return fields.get(1).getUpperNeighbour() != null && !fields.get(1).isUpperNeighbourPlacedField();
        }

        private boolean isThrirdPositionAvailable(List<Field> fields) {
            return fields.get(1).getLowerNeighbour() != null && !fields.get(1).isLowerNeighbourPlacedField();
        }

        private boolean isForthPositionAvailable(List<Field> fields) {
            Field lowerNeighbour = fields.get(1).getLowerNeighbour();
            return lowerNeighbour.getRightNeighbour() != null && !lowerNeighbour.isRightNeighbourPlacedField();
        }

        public void rotate(List<Field> fields) {
            fields.set(0, fields.get(1).getUpperNeighbour());
            fields.set(2, fields.get(1).getLowerNeighbour());
            fields.set(3, fields.get(2).getRightNeighbour());
        }
    }
}