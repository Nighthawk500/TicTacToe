package com.ppa2.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToeGame extends AppCompatActivity {

    //Store the number of rows and columns
    public static final int GRID_SIZE = 3;

    //Create character grid
    private final char[][] mGameGrid;

    //Keep track of X or O
    private char currentPlayer = 'X';

    //Change turn of the player
    public void changePlayer(){
        if (currentPlayer == 'X'){
            currentPlayer = 'Y';
        } else {
            currentPlayer = 'X';
        }
    }

    //Initialize new game
    public TicTacToeGame() {
        mGameGrid = new char[GRID_SIZE][GRID_SIZE];
    }

    //Initialize grid with blank (space) characters
    public void newGame() {
        //Loop through each cell to set each to a blank
        for (int i = 0; i <GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++){
                mGameGrid[i][j] = ' ';
            }
        }
    }

    //Sets the grid cell to an X or Y if empty, then changes turns
    public void setCell(int row, int col) {
        if (mGameGrid[row][col] == ' ') {
            //Sets the grid cell
            mGameGrid[row][col] = currentPlayer;
            //Change the player to X or O
            changePlayer();
        }
    }

    //

    //Check for a win
    public boolean gameWinnerCheck() {
        //Check for win by rows
        for (int i = 0; i < GRID_SIZE; i++) {
            if (mGameGrid[i][0] == currentPlayer && mGameGrid[i][1] == currentPlayer && mGameGrid[i][2] == currentPlayer) {
                return true;
            }
        }

        //Check for win by columns
        for (int i = 0; i < GRID_SIZE; i++) {
            if (mGameGrid[0][i] == currentPlayer && mGameGrid[1][i] == currentPlayer && mGameGrid[2][i] == currentPlayer) {
                return true;
            }
        }

        //Check for win by diagonals
        if (mGameGrid[0][0] == currentPlayer && mGameGrid[1][1] == currentPlayer && mGameGrid[2][2] == currentPlayer) {
            return true;
        }
        if (mGameGrid[0][2] == currentPlayer && mGameGrid[1][1] == currentPlayer && mGameGrid[2][0] == currentPlayer) {
            return true;
        }
        //If no winner
        return false;
    }

    //Check for a draw
    public boolean isDraw() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                //If there is a spot remaining, game is not yet a draw
                if (mGameGrid[i][j] == ' ') {
                    return false;
                }
            }
        }
        //Game is a draw if all spots are filled
        return true;
    }
}
