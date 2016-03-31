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
        setUpFields(jShapePosition);
    }

    @Override
    public void rotate(RotationSide side) {
        ShapeRotation jShapeRotation = rotationVariantCreator.getRotation(fields, side, Shape.J);
        if (jShapeRotation != null && jShapeRotation.isPossible(fields)) {
            jShapeRotation.rotate(fields);
        }
    }
}
