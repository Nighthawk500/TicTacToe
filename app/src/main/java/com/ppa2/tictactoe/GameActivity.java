package com.ppa2.tictactoe;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

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

}