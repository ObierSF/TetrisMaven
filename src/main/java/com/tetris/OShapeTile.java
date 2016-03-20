package com.tetris;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class OShapeTile extends Tile {
    OShapeTile(Board board) {
        super(board);
        color = "BLUE";
        fields = new ArrayList<Field>();
        int[] iShapePosition = {4, 5, 14, 15};
        setUpFields(iShapePosition);
    }

    @Override
    void rotateLeft() {
        //rotation doesn't change a thing
    }

    @Override
    void rotateRight() {
        //rotation doesn't change a thing
    }
}
