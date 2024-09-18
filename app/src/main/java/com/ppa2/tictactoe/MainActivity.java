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

public class MainActivity extends AppCompatActivity {
    //  Joseph Marvin & Andrew Weinert
    //  ISYS 221 - VL1
    //  Pair Programming Assignment #2 - Tic, Tac, Toe
    //  Due: 9/29/2024

    private GridLayout mGameGrid;
    private char mGameX;
    private char mGameY;

    public String turn;

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
            System.out.println(turn + " Wins!");

        }

        public void Quit(View view){
            //a popup will appear
            print "do you want to quit?", options yes/no
            //if yes is selected the app will close
            //if no is selected the popup closes and nothing is changed
            if(result=="yes") {

            }
            else if(result=="no") {
                break;
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