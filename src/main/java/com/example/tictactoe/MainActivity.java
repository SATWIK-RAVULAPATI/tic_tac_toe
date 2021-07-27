package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    // player representation
    // 0-x
    // 1-o
    int activePlayer= 0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    //state meaning
    // 0-x
    //1-o
    //2-blank
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
    int count=0;
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tapppedimage = Integer.parseInt(img.getTag().toString());
        //      if (gameActive == false) {
        //        gameReset(view);
        //  }
            if (gameState[tapppedimage] == 2&&gameActive) {
                count++;
                gameState[tapppedimage] = activePlayer;
                img.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    img.setImageResource(R.drawable.xtt);
                    activePlayer = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText("O's Turn-Tap To Play");
                } else {
                    img.setImageResource(R.drawable.ot);
                    activePlayer = 0;
                    TextView status = findViewById(R.id.status);
                    status.setText("X's Turn-Tap To Play");
                }
                img.animate().translationYBy(1000f).setDuration(300);
            }
            for (int[] winposition : winPositions) {
                if (gameState[winposition[0]] == gameState[winposition[1]] && gameState[winposition[1]] == gameState[winposition[2]]
                        && gameState[winposition[0]] != 2) {
                    //somebody has won
                    gameActive = false;
                    //won = true;
                    String winnerstr;
                    if (gameState[winposition[0]] == 0) {
                        //x has won
                        winnerstr = "X has won";
                    } else {
                        winnerstr = "O has won";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerstr);
                }
            }
            if (count == 9&&gameActive) {
                gameActive=false;
                TextView status = findViewById(R.id.status);
                status.setText("Draw Match!!!");
            }


        }
    public void gameReset(View view)
    {
        gameActive=true;
        activePlayer=0;
        count=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView32)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView33)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView34)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView35)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView36)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView37)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView40)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView41)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView42)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText("X's Turn-Tap To Play");


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




}
