package com.tetris;

import com.tetris.borderstrategy.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by User on 06.03.2016.
 */
public class Field {
    final int height = 16;
    final int width = 10;
    @Getter private boolean partOfTile;
    @Getter private boolean placedField;
    @Getter private int position;
    @Getter private String color;
    @Getter private Border border;
    @Getter @Setter private SurroundingFields surroundingFields;


    Field(int position) {
        this.position = position;
        partOfTile = false;
        placedField = false;
        BorderCreator borderCreator = new BorderCreator();
        try {
            border = borderCreator.getBorder(width, height, position, border);
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void placeField() {
        partOfTile = false;
        placedField = true;
    }

    public void makePartOfTile(String color) {
        this.color = color;
        partOfTile = true;
        placedField = false;
    }

    public void empty() {
        color = "";
        partOfTile = false;
        placedField = false;
    }

    public boolean isEmpty() {
        return !placedField && !partOfTile;
    }

    public Field getRightNeighbour() {
        return surroundingFields.right;
    }

    public Field getLeftNeighbour() {
        return surroundingFields.left;
    }

    public Field getUpperNeighbour() {
        return surroundingFields.upper;
    }

    public Field getLowerNeighbour() {
        return surroundingFields.lower;
    }

    public boolean isLeftNeighbourPlacedField() {
        return surroundingFields.left.isPlacedField();
    }

    public boolean isRightNeighbourPlacedField() {
        return surroundingFields.right.isPlacedField();
    }

    public boolean isUpperNeighbourPlacedField() {
        return surroundingFields.upper.isPlacedField();
    }

    public boolean isLowerNeighbourPlacedField() {
        return surroundingFields.lower.isPlacedField();
    }
}