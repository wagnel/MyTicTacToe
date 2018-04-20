package com.yowaelectronics.wagnel.mytictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Juego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
    }

    // Este metodo recibe el cuadro que es clickable
    public void onGame(View view) {
        // Implement Observer Pattern
        Toast.makeText(this,"Me dieron: ["+view.getId()+"]",Toast.LENGTH_SHORT).show();
    }
}
