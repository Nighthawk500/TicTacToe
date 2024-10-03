package com.ppa2.tictactoe;

public class TicTacToeGame {

    // Store the number of rows and columns
    public static final int GRID_SIZE = 3;

    // Create character grid
    private final char[][] mGameGrid;

    // Keep track of X or O
    private char currentPlayer = 'X';

    public TicTacToeGame() { // initializes the grid and starts a new game
        mGameGrid = new char[GRID_SIZE][GRID_SIZE];
        newGame();
    }

    // Initialize the game grid
    public void newGame() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                mGameGrid[i][j] = ' ';
            }
        }
        currentPlayer = 'X'; // Player X starts
    }

    // Set a cell and change the player
    public void setCell(int row, int col) {
        if (mGameGrid[row][col] == ' ') {
            mGameGrid[row][col] = currentPlayer;
            changePlayer();
        }
    }

    // Change the current player
    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Get the current player
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // Check if there is a winner
    public boolean gameWinnerCheck() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < GRID_SIZE; i++) {
            if (mGameGrid[i][0] == mGameGrid[i][1] && mGameGrid[i][1] == mGameGrid[i][2] && mGameGrid[i][0] != ' ')
                return true;
            if (mGameGrid[0][i] == mGameGrid[1][i] && mGameGrid[1][i] == mGameGrid[2][i] && mGameGrid[0][i] != ' ')
                return true;
        }
        if (mGameGrid[0][0] == mGameGrid[1][1] && mGameGrid[1][1] == mGameGrid[2][2] && mGameGrid[0][0] != ' ')
            return true;
        if (mGameGrid[0][2] == mGameGrid[1][1] && mGameGrid[1][1] == mGameGrid[2][0] && mGameGrid[0][2] != ' ')
            return true;

        return false;
    }

    // Check if the game is a draw
    public boolean isDraw() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (mGameGrid[i][j] == ' ') {
                    return false; //game is not a draw
                }
            }
        }
        return true; //game is a draw
    }
}
