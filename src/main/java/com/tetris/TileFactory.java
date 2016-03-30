package com.tetris;

import com.tetris.shapestrategy.*;
import com.tetris.tile.Tile;

import java.util.*;

/**
 * Created by User on 06.03.2016.
 */
public class TileFactory {
    private Random rand;
    private Board board;
    @SuppressWarnings("unchecked")
    private static final List<ShapeStrategy> shapeStrategy =
            Collections.unmodifiableList(Arrays.<ShapeStrategy>asList(
                    new IShapeStrategy(), new OShapeStrategy(), new TShapeStrategy(),
                    new LShapeStrategy(), new JShapeStrategy(),
                    new SShapeStrategy(), new ZShapeStrategy()));


    TileFactory(Board board) {
        this.board = board;
        rand = new Random();
    }

    Tile returnRandomTile() {
        int n = rand.nextInt(7);
        ShapeStrategy shape = shapeStrategy.get(n);
        Tile tile = shape.getTileShape(board);
        return tile;
    }
}