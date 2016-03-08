package com.tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public class Field {
    final int height = 16;
    final int width = 10;
    boolean isPartOfTile;
    boolean isLocated;
    int position;
    String color;
    Border border;
    List<BorderStrategy> borderStrategy;


    Field(int position) {
        this.position = position;
        isPartOfTile = false;
        isLocated = false;
        prepareBorderStrategy();
        checkBorder();
    }

    void prepareBorderStrategy() {
        borderStrategy = new ArrayList<BorderStrategy>(8);
        borderStrategy.add(new LTCornerStrategy());
        borderStrategy.add(new RTCornerStrategy());
        borderStrategy.add(new LBCornerStrategy());
        borderStrategy.add(new RBCornerStrategy());
        borderStrategy.add(new LeftBorderStrategy());
        borderStrategy.add(new RightBorderStrategy());
        borderStrategy.add(new TopBorderStrategy());
        borderStrategy.add(new BottomBorderStrategy());
    }

    void checkBorder() {
        for (int i=0; i<8; i++) {
            if (borderStrategy.get(i).getBorder(width, height, position) != null) {
                border = borderStrategy.get(i).getBorder(width, height, position);
            }
        }
        if (border == null) {
            border = Border.NONBORDER;
        }
    }

    void locate() {
        isPartOfTile = false;
        isLocated = true;
    }

    void makePartOfTile(String color) {
        this.color = color;
        isPartOfTile = true;
        isLocated = false;
    }

    void empty() {
        color = "";
        isPartOfTile = false;
        isLocated = false;
    }

    boolean isEmpty() {
        return !isLocated && !isPartOfTile;
    }

    int getPosition() {
        return position;
    }
}