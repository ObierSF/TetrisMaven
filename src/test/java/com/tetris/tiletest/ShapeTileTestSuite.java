package com.tetris.tiletest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by User on 31.03.2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        IShapeTileTest.class,
        JShapeTileTest.class,
        LShapeTileTest.class,
        SShapeTileTest.class,
        TShapeTileTest.class,
        ZShapeTileTest.class
})
public class ShapeTileTestSuite {
}
