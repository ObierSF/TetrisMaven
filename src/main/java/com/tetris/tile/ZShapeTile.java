package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class ZShapeTile extends Tile {
    public ZShapeTile(Board board) {
        super(board);
        color = "ORANGE";
        int[] iShapePosition = {5, 15, 14, 24};
        fields.add(board.getField(5));
        fields.add(board.getField(15));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
        makeFieldsPartOfTile();
    }

    @Override
    public void rotate(RotationSide side) {
        try {
            ShapeRotation zShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.Z);
            if (zShapeRotation != null && zShapeRotation.isPossible(fields)) {
                zShapeRotation.rotate(fields);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}