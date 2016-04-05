package com.tetris.tile.rotationvariantstrategy.shaperotation.ishaperotation;

import com.tetris.Field;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public enum IShapeRotation implements ShapeRotation {
    HORIZONTALDOWN {
        public boolean isPossible(List<Field> fields) {
            iShapeRotator = new IShapeHorizontalDownRotation();
            return iShapeRotator.isPossible(fields);
        }

        public void rotate(List<Field> fields) {
            iShapeRotator.rotate(fields);
        }
    },
    VERTICALDOWN {
        public boolean isPossible(List<Field> fields) {
            iShapeRotator = new IShapeVerticalDownRotation();
            return iShapeRotator.isPossible(fields);
        }

        public void rotate(List<Field> fields) {
            iShapeRotator.rotate(fields);
        }
    },
    HORIZONTALUP {
        public boolean isPossible(List<Field> fields) {
            iShapeRotator = new IShapeHorizontalUpRotation();
            return iShapeRotator.isPossible(fields);
        }

        public void rotate(List<Field> fields) {
            iShapeRotator.rotate(fields);
        }
    },
    VERTICALUP {
        public boolean isPossible(List<Field> fields) {
            iShapeRotator = new IShapeVerticalUpRotation();
            return iShapeRotator.isPossible(fields);
        }

        public void rotate(List<Field> fields) {
            iShapeRotator.rotate(fields);
        }
    };

    IShapeRotator iShapeRotator;
}
