package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;

/**
 * Created by User on 06.03.2016.
 */
public class JShapeTile extends Tile {

    public JShapeTile(Board board) {
        super(board);
        color = "GREEN";
        int[] jShapePosition = {5, 15, 25, 24};
        fields.add(board.getField(5));
        fields.add(board.getField(15));
        fields.add(board.getField(25));
        fields.add(board.getField(24));
        makeFieldsPartOfTile();
    }

    @Override
    public void rotate(RotationSide side) {
        try {
            ShapeRotation jShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.J);
            if (jShapeRotation != null && jShapeRotation.isPossible(fields)) {
                jShapeRotation.rotate(fields);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
