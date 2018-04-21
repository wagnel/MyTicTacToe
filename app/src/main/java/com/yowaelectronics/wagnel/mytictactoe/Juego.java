package com.yowaelectronics.wagnel.mytictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Juego extends AppCompatActivity {
    private String order = null;
    private String ficha = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        Intent receivedIntent = getIntent();
        Bundle ref = receivedIntent.getBundleExtra("reference");
        ref.getString("order");
        ref.getString("ficha");
    }

    // Este metodo recibe el cuadro que es clickable
    public void onGame(View view) {
        // Implement Observer Pattern
        ImageButton num1 = findViewById(R.id.num1);
        ImageButton num2 = findViewById(R.id.num2);
        ImageButton num3 = findViewById(R.id.num3);

        ImageButton num4 = findViewById(R.id.num4);
        ImageButton num5 = findViewById(R.id.num5);
        ImageButton num6 = findViewById(R.id.num6);

        ImageButton num7 = findViewById(R.id.num7);
        ImageButton num8 = findViewById(R.id.num8);
        ImageButton num9 = findViewById(R.id.num9);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [1]",Toast.LENGTH_SHORT).show();
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [2]",Toast.LENGTH_SHORT).show();
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [3]",Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------------------------------------//
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [4]",Toast.LENGTH_SHORT).show();
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [5]",Toast.LENGTH_SHORT).show();
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [6]",Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------------------------------------//
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [7]",Toast.LENGTH_SHORT).show();
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [8]",Toast.LENGTH_SHORT).show();
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Me dieron [9]",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
