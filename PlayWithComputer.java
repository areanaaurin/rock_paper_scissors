package com.example.rockpaperscissors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PlayWithComputer extends AppCompatActivity {

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


        rock2.setOnClickListener(view -> {
            imageView8.setImageResource(R.drawable.rocksoza);
            n1 = "r";
            determineWinner();
            textView2.setText("Human:"+Integer.toString(p2)+"Computer:"+Integer.toString(p1));
            if(p1==3 || p2==3)dhong();
        });

        paper2.setOnClickListener(view -> {
            imageView8.setImageResource(R.drawable.papersoza);
            n1 = "p";
            determineWinner();
            textView2.setText("Human:"+Integer.toString(p2)+"Computer:"+Integer.toString(p1));
            if(p1==3 || p2==3)dhong();
        });

        sci2.setOnClickListener(view -> {
            imageView8.setImageResource(R.drawable.scissorsoza);
            n1 = "s";
            determineWinner();
            textView2.setText("Human:"+Integer.toString(p2)+"Computer:"+Integer.toString(p1));
            if(p1==3 || p2==3)dhong();
        });


    }
    private void determineWinner() {

        Random random=new Random();
        int n=random.nextInt(3)+1;//generating random numbers
        if(n==1){
            n2="r";
            imageView7.setImageResource(R.drawable.rocksoza);
        }
        if(n==2){
            n2="p";
            imageView7.setImageResource(R.drawable.papersoza);
        }
        if(n==3){
            n2="s";
            imageView7.setImageResource(R.drawable.scissorsoza);
        }

        if (n1 != null && n2 != null) {
            if (n1.equals(n2)) {
                Toast.makeText(PlayWithComputer.this, "DRAW!", Toast.LENGTH_SHORT).show();
            }
            else if ((n1.equals("r") && n2.equals("s")) || (n1.equals("s") && n2.equals("p")) || (n1.equals("p") && n2.equals("r"))) {
                p2++;
                Toast.makeText(PlayWithComputer.this, "Human Wins!", Toast.LENGTH_SHORT).show();
            }
            else {
                p1++;
                Toast.makeText(PlayWithComputer.this, "Haha!I won!! Better luck next time human!", Toast.LENGTH_SHORT).show();
            }

            // Reset the selected choices
            n1 = null;
            n2 = null;
        }
    }
    private void dhong(){
        if(p1==3){
            winner="Winner:Computer!";
            Intent intent=new Intent(PlayWithComputer.this,Finish.class);
            intent.putExtra("WINNER",winner);
            startActivity(intent);

        }
        if(p2==3) {
            winner="Winner:Human!";
            Intent intent = new Intent(PlayWithComputer.this, Finish.class);
            intent.putExtra("WINNER", winner);
            startActivity(intent);
        }
        p1=0;
        p2=0;
    }
}