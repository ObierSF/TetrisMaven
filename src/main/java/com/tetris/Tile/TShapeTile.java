package com.tetris.Tile;

import com.tetris.Board;
import com.tetris.Tile.RotationVariant.RotationVariantStrategy;
import com.tetris.Tile.RotationVariant.ShapeRotation.TShapeRotation;

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
        TShapeRotation tShapeRotation = getRotation(side);
        if (tShapeRotation != null && tShapeRotation.isPossible(fields)) {
            tShapeRotation.rotate(fields);
        }
    }

    private TShapeRotation getRotation(String side) {
        for (RotationVariantStrategy strategy : rotationVariantStrategies) {
            if (strategy.validate(fields, side)) {
                return strategy.getTShapeRotation();
            }
        }
        return null;
    }
}