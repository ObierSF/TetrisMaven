package com.tetris.tile;

import com.tetris.*;
import com.tetris.tile.move.Move;
import com.tetris.tile.move.MoveCreator;
import com.tetris.tile.move.MoveStrategy;
import com.tetris.tile.rotationstrategy.RotationCreator;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.*;
import lombok.Getter;

import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public abstract class Tile {
    protected RotationVariantCreator rotationVariantCreator;
    protected RotationCreator rotationCreator;
    protected MoveCreator moveCreator;
    @Getter protected List<Field> fields;
    protected Board board;
    protected String color;
    public Shape shape;

    public Tile(Board board) {
        this.board = board;
        rotationVariantCreator = new RotationVariantCreator();
        rotationCreator = new RotationCreator();
        moveCreator = new MoveCreator();
        setUpFields();
    }

    public abstract void setUpFields();

    public void rotate(RotationSide side) {
        if (!shape.equals(Shape.O)) {
            try {
                RotationVariant rotationVariant = rotationVariantCreator.getRotationVariant(fields, side);
                RotationStrategy rotationStrategy = rotationCreator.getRotation(shape, rotationVariant);
                if (rotationStrategy.isPossible(fields)) {
                    rotationStrategy.rotate(fields);
                }
            } catch (Exception e) {
                System.out.println("Rotation exception " + e);
            }
        }
    }

    void makeFieldsPartOfTile() {
        for (Field field : fields) {
            field.makePartOfTile(color);
        }
    }

    public boolean move(Move move) {
        try {
            MoveStrategy moveStrategy = moveCreator.getMove(move);
            if (moveStrategy.isPossible(fields)) {
                moveStrategy.move(fields, color);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Move exception: " + e);
        }
        return false;
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