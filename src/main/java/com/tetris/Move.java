package com.tetris;

import java.util.List;

/**
 * Created by User on 07.03.2016.
 */
public enum Move {
    FALL {
        @Override
        boolean isPossible(int[] fieldsID) {
            for (int i=0; i<fieldsID.length; i++) {
                if (fieldsID[i] + width >= 160)
                    return false;
            }
            return true;
        }

        @Override
        void move(int[] fieldsID) {
            for (int i=0; i<fieldsID.length; i++) {
                fieldsID[i] = fieldsID[i] + width;
            }
        }
    },
    LEFT {
        @Override
        boolean isPossible(int[] fieldsID) {
            for (int i=0; i<fieldsID.length; i++) {
                if (fieldsID[i]-1 < 0 || fieldsID[i] % width < (fieldsID[i]-1) % width)
                    return false;
            }
            return true;
        }

        @Override
        void move(int[] fieldsID) {
            for (int i=0; i<fieldsID.length; i++) {
                fieldsID[i]--;
            }
        }
    },
    RIGHT {
        @Override
        boolean isPossible(int[] fieldsID) {
            for (int i=0; i<fieldsID.length; i++) {
                if (fieldsID[i]+1 > 159 || fieldsID[i] % width > (fieldsID[i]+1) % width)
                    return false;
            }
            return true;
        }

        @Override
        void move(int[] fieldsID) {
            for (int i=0; i<fieldsID.length; i++) {
                fieldsID[i]++;
            }
        }
    };

    final int width = 10;
    abstract boolean isPossible(int[] fieldsID);
    abstract void move(int[] fieldsID);
}
