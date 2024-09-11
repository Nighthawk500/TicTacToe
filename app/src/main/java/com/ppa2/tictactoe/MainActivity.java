package com.ppa2.tictactoe;

import android.os.Bundle;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        public void Winner(String color){
            System.out.println(color + "Wins!");

        }

        public void NextTurn(View view){
            //if three buttons share the same symbol a winner is declared
            // assume this is the position of buttons:
            // 0  1  2
            // 3  4  5
            // 6  7  8
            if button 0,1,2 are the same
                    else if button 0,1,2 are the same
                    else if button 3,4,5 are the same
                    else if button 6,7,8 are the same
                    else if button 0,3,6 are the same
                    else if button 1,4,7 are the same
                    else if button 2,5,8 are the same
                    else if button 0,4,8 are the same
                    else if button 2,4,6 are the same
            //else if three buttons do not share the same symbol, the next player gets a turn
            if(turn == "playerBlue") {
                turn = "playerRed"";
            }
            else if(turn == "playerRed") {
                turn = "playerBlue"
            }
            // if all rows are filled, the game is a tie
        }

        public void NewGame(View view){
            //all symbols are made blank
            for (int i = 0; i < 9; i++) {
                button(i) = "clear";
            }
        }

        public void Quit(View view){
            //a popup will appear
            print "do you want to quit?", options yes/no
            //if yes is selected the app will close
            //if no is selected the popup closes and nothing is changed
            if(result=="yes") {

            }
            else if(result=="no") {
                break
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