package com.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 06.03.2016.
 */
public class TileFactory {
    Random rand;
    List<ShapeStrategy> shapes;
    Board board;

    TileFactory(Board board) {
        this.board = board;
        rand = new Random();
        shapes = new ArrayList<ShapeStrategy>(7);
        shapes.add(new IShapeStrategy());
        shapes.add(new OShapeStrategy());
        shapes.add(new TShapeStrategy());
        shapes.add(new LShapeStrategy());
        shapes.add(new JShapeStrategy());
        shapes.add(new SShapeStrategy());
        shapes.add(new ZShapeStrategy());
    }

    Tile returnRandomTile() {
        int n = rand.nextInt(7);
        ShapeStrategy shape = shapes.get(n);
        Tile tile = shape.getTileShape(board);
        return tile;
    }
}