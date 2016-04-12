package com.tetris.tilefactory;

import com.tetris.Board;
import com.tetris.shapestrategy.*;
import com.tetris.tile.Tile;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationstrategy.RotationCreator;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.HorizontalDownRotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;
import com.tetris.tilefactory.startrotationstrategy.StartRotationCreator;

import java.util.*;

/**
 * Created by User on 06.03.2016.
 */
public class TileFactory {
    private Random rand;
    private Board board;
    private StartRotationCreator startRotationCreator;
    @SuppressWarnings("unchecked")
    private static final List<ShapeStrategy> shapeStrategy =
            Collections.unmodifiableList(Arrays.<ShapeStrategy>asList(
                    new IShapeStrategy(), new OShapeStrategy(), new TShapeStrategy(),
                    new LShapeStrategy(), new JShapeStrategy(),
                    new SShapeStrategy(), new ZShapeStrategy()));

    @SuppressWarnings("unchecked")
    private static final List<RotationVariant> rotationVariants =
            Collections.unmodifiableList(Arrays.<RotationVariant>asList(
                    RotationVariant.HORIZONTALDOWN, RotationVariant.HORIZONTALUP,
                    RotationVariant.VERTICALDOWN, RotationVariant.VERTICALUP));

    public TileFactory(Board board) {
        this.board = board;
        rand = new Random();
        startRotationCreator = new StartRotationCreator();
    }

    public Tile returnRandomTile() {
        int shapeNumber = rand.nextInt(7);
        int rotationNumber = rand.nextInt(4);
        ShapeStrategy shape = shapeStrategy.get(shapeNumber);
        Tile tile = shape.getTileShape(board);
        startRotationCreator.setStartRotation(rotationVariants.get(rotationNumber), tile);
        while (tile.move(Move.UP)) {

        }
        return tile;
    }
}