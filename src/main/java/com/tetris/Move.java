package com.tetris;

import java.util.List;

/**
 * Created by User on 07.03.2016.
 */
public enum Move {
    FALL {
        @Override
        boolean isFieldOnSideNotAvailable(Field field) {
            return field.getLowerNeighbour() == null || field.isLowerNeighbourPlacedField();
        }

        @Override
        void emptyOldFields(List<Field> fields) {
            for (int i=0; i<fields.size(); i++) {
                fields.get(i).empty();
            }
        }

        @Override
        void setUpNewFields(List<Field> fields, String color) {
            for (int i=0; i<fields.size(); i++) {
                fields.set(i, fields.get(i).getLowerNeighbour());
                fields.get(i).makePartOfTile(color);
            }
        }
    },
    LEFT {
        @Override
        boolean isFieldOnSideNotAvailable(Field field) {
            return field.getLeftNeighbour() == null || field.isLeftNeighbourPlacedField();
        }

        @Override
        void emptyOldFields(List<Field> fields) {
            for (int i=0; i<fields.size(); i++) {
                fields.get(i).empty();
            }
        }

        @Override
        void setUpNewFields(List<Field> fields, String color) {
            for (int i=0; i<fields.size(); i++) {
                fields.set(i, fields.get(i).getLeftNeighbour());
                fields.get(i).makePartOfTile(color);
            }
        }
    },
    RIGHT {
        @Override
        boolean isFieldOnSideNotAvailable(Field field) {
            return field.getRightNeighbour() == null || field.isRightNeighbourPlacedField();
        }

        @Override
        void emptyOldFields(List<Field> fields) {
            for (int i=0; i<fields.size(); i++) {
                fields.get(i).empty();
            }
        }

        @Override
        void setUpNewFields(List<Field> fields, String color) {
            for (int i=0; i<fields.size(); i++) {
                fields.set(i, fields.get(i).getRightNeighbour());
                fields.get(i).makePartOfTile(color);
            }
        }
    };

    final int width = 10;
    abstract boolean isFieldOnSideNotAvailable(Field field);
    abstract void emptyOldFields(List<Field> fields);
    abstract void setUpNewFields(List<Field> fields, String color);
    public boolean isPossible(List<Field> fields) {
        for (Field field : fields) {
            if (isFieldOnSideNotAvailable(field)) {
                return false;
            }
        }
        return true;
    }
    public void move(List<Field> fields, String color) {
        emptyOldFields(fields);
        setUpNewFields(fields, color);
    }
}
