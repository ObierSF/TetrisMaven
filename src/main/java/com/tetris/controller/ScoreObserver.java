package com.tetris.controller;

import com.tetris.controller.Controller;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 12.04.2016.
 */
public class ScoreObserver {
    private final int width = 10;
    private final int rowValue = 100;
    @Getter private int score;
    @Getter private List<Integer> rows;

    public ScoreObserver() {
        rows = new LinkedList<Integer>();
    }

    public void noteFullRow(int position) {
        for (Integer row : rows) {
            if (row == (position / width)) {
                return;
            }
        }
        rows.add(position / width);
    }

    public void sumScore() {
        for (Integer row : rows) {
            score += rowValue;
        }
    }

    public void clearRows() {
        rows.clear();
    }
}