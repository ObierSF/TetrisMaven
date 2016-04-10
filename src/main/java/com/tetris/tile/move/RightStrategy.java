package com.tetris.tile.move;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 06.04.2016.
 */
public class RightStrategy extends MoveStrategy {
    @Override
    public boolean validate(Move move) {
        return move.equals(Move.RIGHT);
    }

    @Override
    public boolean isFieldOnSideAvailable(Field field) {
        return field.getRightNeighbour() != null && !field.isRightNeighbourPlacedField();
    }

    @Override
    public void setUpNewFields(List<Field> fields, String color) {
        for (int i=0; i<fields.size(); i++) {
            fields.set(i, fields.get(i).getRightNeighbour());
            fields.get(i).makePartOfTile(color);
        }
    }
}
