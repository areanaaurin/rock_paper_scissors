package com.example.rockpaperscissors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class PlayWithOthers extends AppCompatActivity {

    Button rock1,rock2,paper1,paper2,sci1,sci2;
    ImageView imageView7,imageView8;
    TextView textView2;
    int p1,p2;
    String n1,n2,winner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_with_others);
        rock1 = findViewById(R.id.rock1);
        rock2 = findViewById(R.id.rock2);
        paper1 = findViewById(R.id.paper1);
        sci1 = findViewById(R.id.sci1);
        paper2 = findViewById(R.id.paper2);
        sci2 = findViewById(R.id.sci2);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        textView2=findViewById(R.id.textView2);


        rock1.setOnClickListener(view -> {
            imageView7.setImageResource(R.drawable.rocksoza);
            n1 = "r";
            determineWinner();
            textView2.setText("Player1:"+Integer.toString(p1)+"Player2:"+Integer.toString(p2));
            if(p1==3 || p2==3)dhong();//this method will be called if the condition is satisfied
        });

        paper1.setOnClickListener(view -> {
            imageView7.setImageResource(R.drawable.papersoza);
            n1 = "p";
            determineWinner();
            textView2.setText("Player1:"+Integer.toString(p1)+"Player2:"+Integer.toString(p2));
            if(p1==3 || p2==3)dhong();
        });

        sci1.setOnClickListener(view -> {
            imageView7.setImageResource(R.drawable.scissorsoza);
            n1 = "s";
            determineWinner();
            textView2.setText("Player1:"+Integer.toString(p1)+"Player2:"+Integer.toString(p2));
            if(p1==3 || p2==3)dhong();
        });

        rock2.setOnClickListener(view -> {
            imageView8.setImageResource(R.drawable.rocksoza);
            n2 = "r";
            determineWinner();
            textView2.setText("Player1:"+Integer.toString(p1)+"Player2:"+Integer.toString(p2));
            if(p1==3 || p2==3)dhong();
        });

        paper2.setOnClickListener(view -> {
            imageView8.setImageResource(R.drawable.papersoza);
            n2 = "p";
            determineWinner();
            textView2.setText("Player1:"+Integer.toString(p1)+"Player2:"+Integer.toString(p2));
            if(p1==3 || p2==3)dhong();
        });

        sci2.setOnClickListener(view -> {
            imageView8.setImageResource(R.drawable.scissorsoza);
            n2 = "s";
            determineWinner();
            textView2.setText("Player1:"+Integer.toString(p1)+"Player2:"+Integer.toString(p2));
            if(p1==3 || p2==3)dhong();
        });
    }

    private void determineWinner() {//deciding winner
        if (n1 != null && n2 != null) {
            if (n1.equals(n2)) {
                Toast.makeText(PlayWithOthers.this, "DRAW!", Toast.LENGTH_SHORT).show();
            }
            else if ((n1.equals("r") && n2.equals("s")) || (n1.equals("s") && n2.equals("p")) || (n1.equals("p") && n2.equals("r"))) {
                p1++;
                //winner = "player1";
                Toast.makeText(PlayWithOthers.this, "PLAYER1 WINS!", Toast.LENGTH_SHORT).show();
            }
            else {
                p2++;
                //winner = "player2";
                Toast.makeText(PlayWithOthers.this, "PLAYER2 WINS!", Toast.LENGTH_SHORT).show();
            }

            // Reset the selected choices
            n1 = null;
            n2 = null;

        }
    }
    private void dhong(){
        if(p1==3){
            winner="Winner:player1!";
            Intent intent=new Intent(PlayWithOthers.this,Finish.class);
            intent.putExtra("WINNER",winner);
            startActivity(intent);

        }
        if(p2==3) {
            winner="Winner:player2!";
            Intent intent = new Intent(PlayWithOthers.this, Finish.class);
            intent.putExtra("WINNER", winner);
            startActivity(intent);
        }
        p1=0;
        p2=0;//reset the numbers after 3 rounds
    }

}