package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class TShapeTile extends Tile {
    public TShapeTile(Board board) {
        super(board);
        color = "YELLOW";
        fields.add(board.getField(4));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
        fields.add(board.getField(13));
        makeFieldsPartOfTile();
    }

    @Override
    public void rotate(RotationSide side) {
        try {
            ShapeRotation tShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.T);
            if (tShapeRotation != null && tShapeRotation.isPossible(fields)) {
                tShapeRotation.rotate(fields);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}