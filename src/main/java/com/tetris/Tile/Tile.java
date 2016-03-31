package com.tetris.tile;

import com.tetris.*;
import com.tetris.tile.rotationvariantstrategy.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public abstract class Tile {
    RotationVariantCreator rotationVariantCreator;
    @Getter protected List<Field> fields;
    protected Board board;
    protected String color;

    public Tile(Board board) {
        this.board = board;
        rotationVariantCreator = new RotationVariantCreator();
    }

    public abstract void rotate(RotationSide side);

    void setUpFields(int[] shapePosition) {
        fields = new ArrayList<Field>();
        for (int i : shapePosition) {
            fields.add(board.getField(i));
        }
        makeFieldsPartOfTile();
    }

    void makeFieldsPartOfTile() {
        for (Field field : fields) {
            field.makePartOfTile(color);
        }
    }

    public boolean isMovePossible(Move move) {
        return move.isPossible(fields);
    }

    public void move(Move move) {
        move.move(fields, color);
    }

    public void placeTile() {
        for (Field field : fields) {
            field.placeField();
        }
    }

    public int getFieldPosition(int n) {
        return fields.get(n).getPosition();
    }
}