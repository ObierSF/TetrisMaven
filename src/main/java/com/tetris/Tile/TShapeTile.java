package com.tetris.tile;

import com.tetris.Board;
import com.tetris.tile.rotationvariantstrategy.RotationVariantStrategy;
import com.tetris.tile.rotationvariantstrategy.shaperotation.ShapeRotation;

/**
 * Created by User on 06.03.2016.
 */
public class TShapeTile extends Tile {
    public TShapeTile(Board board) {
        super(board);
        color = "YELLOW";
        int[] iShapePosition = {4, 14, 24, 13};
        setUpFields(iShapePosition);
    }

    @Override
    public void rotate(String side) {
        ShapeRotation tShapeRotation = getRotation(side);
        if (tShapeRotation != null && tShapeRotation.isPossible(fields)) {
            tShapeRotation.rotate(fields);
        }
    }

    private ShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getShapeRotation("T");
            }
        }
        return null;
    }
}