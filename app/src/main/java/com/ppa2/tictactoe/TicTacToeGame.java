package com.ppa2.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToeGame extends AppCompatActivity {

    public static final int GRID_SIZE = 3;

    private final char[][] mGameGrid;

    private char currentPlayer = 'X';

    public void changePlayer(){
        if (currentPlayer == 'X'){
            currentPlayer = 'Y';
        } else {
            currentPlayer = 'X';
        }
    }

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
    public char gameWinner() {
        // Check rows
        for (int i = 0; i < GRID_SIZE; i++) {
            if (mGameGrid[i][0] == currentPlayer && mGameGrid[i][1] == currentPlayer && mGameGrid[i][2] == currentPlayer) {
                return true;
            }
        }

        // Check columns win
        for (int i = 0; i < GRID_SIZE; i++) {
            if (mGameGrid[0][i] == currentPlayer && mGameGrid[1][i] == currentPlayer && mGameGrid[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (mGameGrid[0][0] == currentPlayer && mGameGrid[1][1] == currentPlayer && mGameGrid[2][2] == currentPlayer) {
            return true;
        }

        if (mGameGrid[0][2] == currentPlayer && mGameGrid[1][1] == currentPlayer && mGameGrid[2][0] == currentPlayer) {
            return true;
        }
    }
}