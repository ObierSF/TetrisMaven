package com.tetris.tile.rotationvariantstrategy.shaperotation;

import com.tetris.Field;

import java.util.List;

/**
 * Created by User on 23.03.2016.
 */
public interface ShapeRotation {
    boolean isPossible(List<Field> fields);
    void rotate(List<Field> fields);
}