package com.example.rockpaperscissors;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button others,comp,inst;
        others=findViewById(R.id.others);
        comp=findViewById(R.id.comp);
        inst=findViewById(R.id.inst);
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,PlayWithOthers.class);
                startActivity(i);
                finish();
            }
        });
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(MainActivity.this,PlayWithComputer.class);
                startActivity(in);
                finish();
            }
        });
        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,inst.class);
                startActivity(intent);
                finish();
            }
        });
    }
}