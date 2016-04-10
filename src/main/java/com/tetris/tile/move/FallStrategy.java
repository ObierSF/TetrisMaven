package com.tetris.tile.move;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 06.04.2016.
 */
public class FallStrategy extends MoveStrategy {
    @Override
    public boolean validate(Move move) {
        return move.equals(Move.FALL);
    }

    @Override
    public boolean isFieldOnSideAvailable(Field field) {
        return field.getLowerNeighbour() != null && !field.isLowerNeighbourPlacedField();
    }

    @Override
    public void setUpNewFields(List<Field> fields, String color) {
        for (int i=0; i<fields.size(); i++) {
            fields.set(i, fields.get(i).getLowerNeighbour());
            fields.get(i).makePartOfTile(color);
        }
    }
}
