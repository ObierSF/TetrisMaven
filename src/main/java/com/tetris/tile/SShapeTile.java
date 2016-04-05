package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class SShapeTile extends Tile {
    public SShapeTile(Board board) {
        super(board);
        color = "GRAY";
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(15));
        fields.add(board.getField(25));
        makeFieldsPartOfTile();
    }

    @Override
    public void rotate(RotationSide side) {
        try {
            ShapeRotation sShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.S);
            if (sShapeRotation != null && sShapeRotation.isPossible(fields)) {
                sShapeRotation.rotate(fields);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}