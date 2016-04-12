package com.tetris.tile.move;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.tile.Color;

import java.util.List;

/**
 * Created by User on 12.04.2016.
 */
public class UpStrategy extends MoveStrategy {
    @Override
    public boolean validate(Move move) {
        return move == Move.UP;
    }

    @Override
    public boolean isFieldOnSideAvailable(Field field) {
        return field.getNeighbour(Neighbour.UPPER) != null && !field.isNeighbourPlacedField(Neighbour.UPPER);
    }

    @Override
    public void setUpNewFields(List<Field> fields, Color color) {
        for (int i=0; i<fields.size(); i++) {
            fields.set(i, fields.get(i).getNeighbour(Neighbour.UPPER));
            fields.get(i).makePartOfTile(color);
        }
    }
}