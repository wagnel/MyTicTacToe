package com.yowaelectronics.wagnel.mytictactoe;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String ficha, modo;
    private RadioButton p1_vs_pc, p1_vs_p2, circle;
    private CheckBox orden = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.circle = findViewById(R.id.radioBtnCircle);
        this.ficha = (circle.isChecked()) ? "circle" : "cruz";
        this.p1_vs_pc = findViewById(R.id.player1_vs_computer);
        this.p1_vs_p2 = findViewById(R.id.player1_vs_player2);
        this.modo = (p1_vs_p2.isChecked()) ? p1_vs_pc.getTag().toString() : p1_vs_p2.getTag().toString();
        this.orden = findViewById(R.id.chkFirstToPlay); // Variable que almacena quien es el primer jugador
    }

    public void playGame(View view) {
        Bundle b = new Bundle();
        b.putString("ficha",ficha);
        b.putString("modo",modo);
        b.putString("orden", ((orden.isChecked()) ? "1" : "2"));

        Intent i = new Intent(this, Juego.class);
        i.putExtra("reference",b);
        startActivity(i);
    }
}
