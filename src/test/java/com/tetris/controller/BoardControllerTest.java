package com.tetris.controller;

import com.tetris.Board;
import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by User on 20.04.2016.
 */
public class BoardControllerTest {
    @Ignore
    @Test
    public void shouldReturnTrueIfRowIsFullAndClearThem() throws Exception {
        //given
        int     width = 10,
                height = 16;
        BoardController boardController = new BoardController(width, height);
        Board board = boardController.getBoard();
        int[] bottomFullRowFieldsPositions = {150, 151, 152, 153, 154, 155, 156, 157, 158, 159};
        int[] preBottomNotFullRowFieldsPositions = {140, 141, 142, 143, 145, 146, 147, 148, 149};
        Color pseudoRandomColor = Color.BLUE;
        //when
        for (int bottomFullRowFieldsPosition : bottomFullRowFieldsPositions) {
            board.getField(bottomFullRowFieldsPosition).placeField(pseudoRandomColor);
        }
        for (int preBottomNotFullRowFieldsPosition : preBottomNotFullRowFieldsPositions) {
            board.getField(preBottomNotFullRowFieldsPosition).placeField(pseudoRandomColor);
        }
        //then
    }
}