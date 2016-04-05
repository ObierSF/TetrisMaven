package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class IShapeTile extends Tile {

    public IShapeTile(Board board) {
        super(board);
        color = "RED";
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
        fields.add(board.getField(34));
        makeFieldsPartOfTile();
    }

    @Override
    public void rotate(RotationSide side) {
        try {
            ShapeRotation iShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.I);
            if (iShapeRotation != null && iShapeRotation.isPossible(fields)) {
                iShapeRotation.rotate(fields);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}