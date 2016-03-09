package com.tetris;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 09.03.2016.
 */
public class BorderStrategyTest extends TestCase {
    final int height = 16;
    final int width = 10;
    List<BorderStrategy> borderStrategy;
    Border border;

    public void setUp() throws Exception {
        super.setUp();
        borderStrategy = new ArrayList<BorderStrategy>();
        borderStrategy.add(new LTCornerStrategy());
        borderStrategy.add(new RTCornerStrategy());
        borderStrategy.add(new LBCornerStrategy());
        borderStrategy.add(new RBCornerStrategy());
        borderStrategy.add(new LeftBorderStrategy());
        borderStrategy.add(new RightBorderStrategy());
        borderStrategy.add(new TopBorderStrategy());
        borderStrategy.add(new BottomBorderStrategy());
        borderStrategy.add(new NonBorderStrategy());
    }

    void checkBorder(int position) {
        for (BorderStrategy strategy : borderStrategy) {
            if (strategy.validate(width, height, position, border)) {
                border = strategy.getBorder();
            }
        }
    }

    public void testLTConrner() throws Exception {
        checkBorder(0);
    }

    public void testRTConrner() throws Exception {
        checkBorder(width-1);
    }

    public void testLBConrner() throws Exception {
        checkBorder(height*width-width);
    }

    public void testRBConrner() throws Exception {
        checkBorder(height*width-1);
    }

    public void testLeftBorder() throws Exception {
        checkBorder(width*7);
    }

    public void testRightBorder() throws Exception {
        checkBorder(width*12-1);
    }

    public void testTopBorder() throws Exception {
        checkBorder(1);
    }

    public void testBottomBorder() throws Exception {
        checkBorder(height*width-2);
    }

    public void testNonBorder() throws Exception {
        checkBorder(width*14+8);
    }
}