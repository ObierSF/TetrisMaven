package com.tetris.tile.move;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 06.04.2016.
 */
public class LeftStrategy extends MoveStrategy {
    @Override
    public boolean validate(Move move) {
        return move == Move.LEFT;
    }

    @Override
    public boolean isFieldOnSideAvailable(Field field) {
        return field.getLeftNeighbour() != null && !field.isLeftNeighbourPlacedField();
    }

    @Override
    public void setUpNewFields(List<Field> fields, String color) {
        for (int i=0; i<fields.size(); i++) {
            fields.set(i, fields.get(i).getLeftNeighbour());
            fields.get(i).makePartOfTile(color);
        }
    }
}
