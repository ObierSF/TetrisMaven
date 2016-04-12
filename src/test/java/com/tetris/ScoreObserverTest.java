package com.tetris;

import com.tetris.controller.Controller;
import com.tetris.controller.ScoreObserver;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 12.04.2016.
 */
public class ScoreObserverTest {
    private final int width = 10;
    private final int height = 16;
    ScoreObserver scoreObserver;

    @Before
    public void setUp() throws Exception {
        scoreObserver = new ScoreObserver();
    }

    @Test
    public void shouldNoteFullRowAndClearRowsList() throws Exception {
        //given
        int pseudoRandomFieldPosition = 155;
        List<Integer> rows;
        //when
        scoreObserver.noteFullRow(pseudoRandomFieldPosition);
        rows = scoreObserver.getRows();
        //then
        assertEquals((pseudoRandomFieldPosition / width), (int)rows.get(0));
        //and when
        scoreObserver.clearRows();
        //then
        assertTrue(rows.isEmpty());
    }

    @Test
    public void shouldNotNoteSameFullRowTwiceAndCountScore() throws Exception {
        //given
        int     score,
                expectedScore = 200,
                firstPseudoRandomFieldPosition = 144,
                secondPseudoRandomFieldPosition = 145,
                thirdPseudoRandomFieldPosition = 155;
        List<Integer> rows;
        //when
        scoreObserver.noteFullRow(firstPseudoRandomFieldPosition);
        scoreObserver.noteFullRow(secondPseudoRandomFieldPosition);
        scoreObserver.noteFullRow(thirdPseudoRandomFieldPosition);
        scoreObserver.sumScore();
        rows = scoreObserver.getRows();
        score = scoreObserver.getScore();
        //then
        assertEquals((firstPseudoRandomFieldPosition / width), (int)rows.get(0));
        assertEquals((thirdPseudoRandomFieldPosition / width), (int)rows.get(1));
        assertEquals(expectedScore, score);
    }
}