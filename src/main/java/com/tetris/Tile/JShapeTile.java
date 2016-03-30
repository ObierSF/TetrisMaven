package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;

/**
 * Created by User on 06.03.2016.
 */
public class JShapeTile extends Tile {

    public JShapeTile(Board board) {
        super(board);
        color = "GREEN";
        int[] jShapePosition = {5, 15, 24, 25};
        setUpFields(jShapePosition);
    }

    @Override
    public void rotate(String side) {
        ShapeRotation jShapeRotation = getRotation(side);
        if (jShapeRotation != null && jShapeRotation.isPossible(fields)) {
            jShapeRotation.rotate(fields);
        }
    }

    private ShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getShapeRotation("J");
            }
        }
        return null;
    }
}
