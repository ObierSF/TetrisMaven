package com.tetris.tile.move;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 06.04.2016.
 */
public abstract class MoveStrategy {
    public abstract boolean validate(Move move);
    public abstract boolean isFieldOnSideAvailable(Field field);
    public abstract void setUpNewFields(List<Field> fields, String color);

    public void emptyOldFields(List<Field> fields) {
        for (int i=0; i<fields.size(); i++) {
            fields.get(i).empty();
        }
    }

    public boolean isPossible(List<Field> fields) {
        for (Field field : fields) {
            if (!isFieldOnSideAvailable(field)) {
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
