package com.ppa2.tictactoe;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

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
    private TextView playerIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize game grid and game model
        tictactoegrid = findViewById(R.id.game_grid);
        mGame = new TicTacToeGame();
        mGame.newGame();

        //set the player turn indicator
        playerIndicator = findViewById(R.id.turndisplay);

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

        //set the textview that displays the current turn
        playerIndicator.setText(String.valueOf(mGame.getCurrentPlayer() == 'X' ? 'O' : 'X'));


        // Check if there is a winner or a draw
        if (mGame.gameWinnerCheck()) {
            // If there is a winner and X is current player, return O, if O is current return X
            showWinnerDialog(mGame.getCurrentPlayer() == 'X' ? 'O' : 'X');
            // If the game is a draw return D
        } else if (mGame.isDraw()) {
            showWinnerDialog('D');
        }
    }

    // Show a dialog with the game result
    private void showWinnerDialog(char winner) {
        gameOver = true;
        String message = (winner == 'D') ? "It's a draw!" : "Player " + winner + " wins!"; //creates a string that announces the winner

        new AlertDialog.Builder(this) // creates a dialog to display the string
                .setTitle("Game Over")
                .setMessage(message)
                .setPositiveButton("New Game", (dialog, which) -> onNewGameClick())
                .setNegativeButton("Quit", (dialog, which) -> finish())
                .show();
    }

    // Starting a new game from the new game button
    public void onNewGameClick() {
        mGame.newGame();
        gameOver = false;

        // Clear all buttons in the grid
        for (int buttonIndex = 0; buttonIndex < tictactoegrid.getChildCount(); buttonIndex++) {
            Button gridButton = (Button) tictactoegrid.getChildAt(buttonIndex);
            gridButton.setText("");
            gridButton.setEnabled(true);
            playerIndicator.setText(String.valueOf(mGame.getCurrentPlayer() == 'X' ? 'O' : 'X'));
        }
    }

    // Handle quit button click
    public void onQuitClick() {
        // Create required alert messages
        new AlertDialog.Builder(this)
                .setMessage("Are you sure?")
                .setTitle("Quit")
                .setPositiveButton("Yes", (dialog, id) -> finish())
                .setNegativeButton("No", (dialog, id) -> dialog.dismiss())
                .create().show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // If new game button is clicked
        if (id == R.id.action_new_game) {
            onNewGameClick();
            return true;
        // If quit game button is clicked
        } else if (id == R.id.action_quit) {
            onQuitClick();
            return true;
        }
        // Event passed to parent in case there are other items added, so the click won't be ignored
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Add items to menu bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
