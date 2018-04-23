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
    private String modo;
    private RadioButton p1_vs_pc, p1_vs_p2, circle;
    private CheckBox orden = null; // Numero de los jugadores para empezar el juego, [1] El Player1 empieza primero, [2] La maquina empieza primero

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.p1_vs_pc = findViewById(R.id.player1_vs_computer);
        this.p1_vs_p2 = findViewById(R.id.player1_vs_player2);
        this.circle = findViewById(R.id.radioBtnCircle);
        this.orden = findViewById(R.id.chkFirstToPlay); // Variable que almacena quien es el primer jugador
    }

    // Este metodo es llamado por el boton Start que inicia el juego
    public void playGame(View view) {
        Bundle b = new Bundle();
        b.putString("ficha", ((circle.isChecked()) ? "circle" : "cruz"));
        b.putString("modo", ((p1_vs_p2.isChecked()) ? p1_vs_p2.getTag().toString() : p1_vs_pc.getTag().toString()));
        b.putString("orden", ((orden.isChecked()) ? "1" : "2"));

        Intent i = new Intent(this, Juego.class);
        i.putExtra("reference",b);
        startActivity(i);
    }

    // Este metodo es llamado cuando el Player 1 quiere jugar con la maquina
    public void onPlayer1vsComputerClick(View view) {
        CheckBox chFirstToPlay = findViewById(R.id.chkFirstToPlay);

        if (view.getId() == R.id.player1_vs_computer)
            chFirstToPlay.setEnabled(true);
        else
            chFirstToPlay.setEnabled(false);
    }
}
