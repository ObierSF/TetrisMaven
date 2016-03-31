package com.tetris.tiletest.rotationvarianttest;

import com.tetris.tiletest.rotationvarianttest.shaperotationtest.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by User on 31.03.2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        HorizontalDownRotationStrategyTest.class,
        HorizontalUpRotationStrategyTest.class,
        VerticalDownRotationStrategyTest.class,
        VerticalUpRotationStrategyTest.class
})
public class RotationVariantTestSuite {
}
