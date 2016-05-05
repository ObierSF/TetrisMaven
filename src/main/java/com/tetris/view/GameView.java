package com.tetris.view;

import com.tetris.Board;
import com.tetris.view.fieldview.CompositeFieldView;
import com.tetris.view.fieldview.ChildFieldView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 24.04.2016.
 */
public class GameView extends JPanel {
    private static final int dimensionWidth = 400;
    private static final int dimensionHeight = 640;
    private static final int width = 10;
    private static final int height = 16;
    private CompositeFieldView compositeFieldView;
    private Board board;

    public GameView(Board board, int fieldsNumber) {
        this.board = board;
        compositeFieldView = new CompositeFieldView();
        for (int fieldNumber=0; fieldNumber<fieldsNumber; fieldNumber++) {
            int column = fieldNumber % width;
            int row = fieldNumber / width;
            compositeFieldView.addField(new ChildFieldView(column, row, board.getField(fieldNumber)));
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        compositeFieldView.draw(graphics);
    }

    public Dimension getPreferredSize() {
        return new Dimension(dimensionWidth, dimensionHeight);
    }
}