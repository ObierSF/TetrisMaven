package com.tetris.BorderStrategy;

import com.tetris.Border;

/**
 * Created by User on 08.03.2016.
 */
public interface BorderStrategy {
    boolean validate(int width, int height, int position, Border border);
    Border getBorder();
}