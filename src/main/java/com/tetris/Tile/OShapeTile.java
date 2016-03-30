package com.tetris.tile;

import com.tetris.Board;
import com.tetris.Field;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class OShapeTile extends Tile {
    public OShapeTile(Board board) {
        super(board);
        color = "BLUE";
        fields = new ArrayList<Field>();
        int[] iShapePosition = {4, 5, 14, 15};
        setUpFields(iShapePosition);
    }

    @Override
    public void rotate(String side) {

    }
}
