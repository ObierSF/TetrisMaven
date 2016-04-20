package com.tetris.borderstrategy;

import com.tetris.borderstrategy.Border;
import com.tetris.borderstrategy.BorderStrategy;
import com.tetris.borderstrategy.BottomBorderStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by User on 19.04.2016.
 */
public class BottomBorderStrategyTest {
    private final int width = 10;
    private final int height = 16;
    private BorderStrategy borderStrategy;
    private Border border;
    private Border nullBorder;


    @Test
    public void shouldReturnBorderIfFieldIsOnBottomBorder() throws Exception {
        //given
        int position = height*width-2; //random bottom border position
        int badPosition = 55;
        borderStrategy = new BottomBorderStrategy();
        //when
        if (borderStrategy.validate(width, height, position, border)) {
            border = borderStrategy.getBorder();
        }
        if (borderStrategy.validate(width, height, badPosition, nullBorder)) {
            nullBorder = borderStrategy.getBorder();
        }
        //then
        assertEquals(Border.BOTTOM, border);
        assertNull(nullBorder);
    }
}
