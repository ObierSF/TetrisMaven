package com.tetris.tilefactory.startrotationstrategy;

import com.tetris.tile.Tile;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

/**
 * Created by User on 12.04.2016.
 */
public class VerticalDownRotation implements StartRotationStrategy {
    public boolean validate(RotationVariant rotationVariant) {
        return rotationVariant == RotationVariant.VERTICALDOWN;
    }

    public void rotate(Tile tile) {
        tile.rotate(RotationSide.RIGHT);
        tile.rotate(RotationSide.RIGHT);
    }
}
