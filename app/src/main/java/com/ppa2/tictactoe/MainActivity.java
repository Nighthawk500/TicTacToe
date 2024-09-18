package com.ppa2.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    //  Joseph Marvin & Andrew Weinert
    //  ISYS 221 - VL1
    //  Pair Programming Assignment #2 - Tic, Tac, Toe
    //  Due: 9/29/2024

    private GridLayout mGameGrid;
    private char mGameX;
    private char mGameY;

    public String turn = "X";

    private GridLayout tictactoegrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tictactoegrid = findViewById(R.id.game_grid);

        for (int buttonIndex = 0; buttonIndex < tictactoegrid.getChildCount(); buttonIndex++) {
            Button gridButton = (Button) tictactoegrid.getChildAt(buttonIndex);
            gridButton.setOnClickListener(this::onGridButtonClick);
        }

        public void Winner(String turn){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.dialog_message)
                   .setTitle(R.string.dialog_title);
                   AlertDialog dialog = builder.create();
        }

        public void Quit(View view){

        }

        final int gridSize = TicTacToeGame.GRID_SIZE;
        //Update the appropriate grid cell
        private void updateGrid() {
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    //Retrieves the cell button from the grid
                    Button button = (Button) mGameGrid.getChildAt(i * gridSize + j);
                    //Set and convert the character of the appropriate cell to a String
                    button.setText(String.valueOf(mGameGrid[i][j]));
                    //Enables button if the space is blank
                    button.setEnabled(mGameGrid[i][j] == ' ');
                }
            }
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }



        });
    }



}