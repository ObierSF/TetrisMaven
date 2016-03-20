package com.tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 07.03.2016.
 */
public enum Border {
    LEFTTOPCORNER {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = null;
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = null;
            return surroundingFields;
        }
    },
    RIGHTTOPCORNER {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = null;
            surroundingFields.right = null;
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    LEFTBOTTOMCORNER {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = null;
            surroundingFields.left = null;
            return surroundingFields;
        }
    },
    RIGHTBOTTOMCORNER {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = null;
            surroundingFields.lower = null;
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    LEFT {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = null;
            return surroundingFields;
        }
    },
    RIGHT {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = null;
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    TOP {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = null;
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    BOTTOM {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = null;
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    NONBORDER {
        @Override
        SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    };

    final int width = 10;
    final int height = 16;
    abstract SurroundingFields determineTheSurroundingFields(Board board, int position);
}
