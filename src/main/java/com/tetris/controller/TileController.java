package com.tetris.controller;

import com.tetris.Board;
import com.tetris.field.Field;
import com.tetris.tilefactory.RandomisedTileFactory;
import com.tetris.tilefactory.TileFactory;
import com.tetris.field.Neighbour;
import com.tetris.tile.Tile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Observable;

/**
 * Created by User on 21.03.2016.
 */
public class TileController extends Observable {
    private int width;
    private TileFactory tileFactory;
    @Setter @Getter private Tile tile;

    public TileController(int width, Board board) {
        this.width = width;
        tileFactory = new RandomisedTileFactory(board);
    }

    public boolean isAddingTilePossible() {
        tileFactory.generateRandomTile();
        return tileFactory.isAddingTilePossible();
    }

    public void setRandomTile() {
        tile = tileFactory.getTile();
        tile.makeFieldsPartOfTile();
    }

    public void placeTile() {
        tile.placeTile();
    }

    public void searchForFullRows() {
        List<Field> fields = tile.getFields();
        for (Field field : fields) {
            if (field.isSideOfRowFull(Neighbour.LEFT) && field.isSideOfRowFull(Neighbour.RIGHT)) {
                setChanged();
                notifyObservers(field.getPosition());
            }
        }
    }

    public boolean isFallPossible() {
        return tile.isFallPossible();
    }

    public void setLastTile() {
        tileFactory.setLastTile();
    }
}
