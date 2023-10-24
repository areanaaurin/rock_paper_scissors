package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finish extends AppCompatActivity {
    TextView Name;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Name = findViewById(R.id.textView);
        button2=findViewById(R.id.button2);

        // Retrieve the winner value from the intent
        String winner = getIntent().getStringExtra("WINNER");

        // Display the winner in the TextView
        if (winner != null) {
            Name.setText( winner);
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Finish.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}