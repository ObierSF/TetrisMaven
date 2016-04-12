package com.tetris.controller;

import com.tetris.Board;
import com.tetris.field.Field;
import com.tetris.tilefactory.TileFactory;
import com.tetris.field.Neighbour;
import com.tetris.tile.Tile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by User on 21.03.2016.
 */
public class Controller {
    private int width;
    @Getter private Board board;
    private TileFactory tileFactory;
    @Setter @Getter private Tile tile;
    private ScoreObserver scoreObserver;

    public Controller(int width, int height) {
        this.width = width;
        board = new Board(width * height);
        tileFactory = new TileFactory(board);
        scoreObserver = new ScoreObserver();
    }

    public void setRandomTile() {
        tile = tileFactory.returnRandomTile();
    }

    public void placeTile() {
        tile.placeTile();
    }

    public void searchForFullRows() {
        List<Field> fields = tile.getFields();
        for (Field field : fields) {
            if (field.isSideOfRowFull(Neighbour.LEFT) && field.isSideOfRowFull(Neighbour.RIGHT)) {
                scoreObserver.noteFullRow(field.getPosition());
            }
        }
    }

    public void sumScore() {
        scoreObserver.sumScore();
    }

    public void clearFullRows() {
        List<Integer> rows = scoreObserver.getRows();
        for (Integer row : rows) {
            board.getField(row * width).clearRow();
        }
        scoreObserver.clearRows();
    }

    public int getScore() {
        return scoreObserver.getScore();
    }
}
