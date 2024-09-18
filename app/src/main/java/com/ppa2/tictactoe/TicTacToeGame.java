package com.ppa2.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToeGame extends AppCompatActivity {

    public static final int GRID_SIZE = 3;

    private final char[][] mGameGrid;

    public TicTacToeGame() {
        mGameGrid = new char[GRID_SIZE][GRID_SIZE];
    }

    //Initialize grid with blank (space) characters
    public void newGame() {
        //
        for (int i = 0; i <GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++){
                mGameGrid[i][j] = ' ';
            }
        }
    }

    //Check for a win
    public boolean gameWinner
}