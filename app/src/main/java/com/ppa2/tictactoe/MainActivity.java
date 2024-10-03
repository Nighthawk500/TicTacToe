package com.ppa2.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //  Joseph Marvin & Andrew Weinert
    //  ISYS 221 - VL1
    //  Pair Programming Assignment #2 - Tic, Tac, Toe
    //  Due: 10/6/2024

    private GridLayout tictactoegrid;
    private TicTacToeGame mGame;
    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize game grid and game model
        tictactoegrid = findViewById(R.id.game_grid);
        mGame = new TicTacToeGame();
        mGame.newGame();

        // Create listener for buttons
        for (int buttonIndex = 0; buttonIndex < tictactoegrid.getChildCount(); buttonIndex++) {
            Button gridButton = (Button) tictactoegrid.getChildAt(buttonIndex);
            final int row = buttonIndex / 3;
            final int col = buttonIndex % 3;
            gridButton.setOnClickListener(view -> onGridButtonClick(gridButton, row, col));
        }
    }

    // Handle button clicks on the grid
    public void onGridButtonClick(Button button, int row, int col) {
        if (gameOver) return;

        // Set the cell in the model and update the button text
        mGame.setCell(row, col);
        button.setText(String.valueOf(mGame.getCurrentPlayer()));
        button.setEnabled(false);

        // Check if there is a winner or a draw
        if (mGame.gameWinnerCheck()) {
            showWinnerDialog(mGame.getCurrentPlayer() == 'X' ? 'O' : 'X');
        } else if (mGame.isDraw()) {
            showWinnerDialog('D');
        }
    }

    // Show a dialog with the game result (X, O, or Draw)
    private void showWinnerDialog(char winner) {
        gameOver = true;
        String message = (winner == 'D') ? "It's a draw!" : "Player " + winner + " wins!";
        new AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage(message)
                .setPositiveButton("New Game", (dialog, which) -> onNewGameClick())
                .setNegativeButton("Quit", (dialog, which) -> finish())
                .show();
    }

    // Start a new game
    public void onNewGameClick(View view) {
        onNewGameClick();
    }

    public void onNewGameClick() {
        mGame.newGame();
        gameOver = false;

        // Clear all buttons in the grid
        for (int buttonIndex = 0; buttonIndex < tictactoegrid.getChildCount(); buttonIndex++) {
            Button gridButton = (Button) tictactoegrid.getChildAt(buttonIndex);
            gridButton.setText("");
            gridButton.setEnabled(true);
        }
    }

    // Handle quit button click
    public void onQuitClick(View view) {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure?")
                .setTitle("Quit")
                .setPositiveButton("Yes", (dialog, id) -> finish())
                .setNegativeButton("No", (dialog, id) -> dialog.dismiss())
                .create().show();
    }
}
