package com.yowaelectronics.wagnel.mytictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    private Random random = new Random(9); // 9 posiciones tiene el Tic Tac Toe;
    private String ficha = null;
    private int rutaFicha = 0;
    private int cantJugadas = 0; // Cantidad de jugadas que hacen los jugadores
    private ArrayList<String> jugadaMaquina = new ArrayList<>(); // Lugares donde juega la maquina
    private ArrayList<String> jugadaUsuario = new ArrayList<>(); // Lugares donde juega el usuario
    private int usuario = 1; // Esta variable define si el usuario juega primero
    private int estadoJugada = 0; // Esta variable define [0] si los dos ya hab jugado, [1] si todavia falta uno por jugar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        Intent receivedIntent = getIntent();
        Bundle ref = receivedIntent.getBundleExtra("reference");
        usuario = (ref.get("order")=="1"?1:2);
        ficha = ref.getString("ficha");
        rutaFicha = (ficha == "circle") ? R.mipmap.circle : R.mipmap.cruz;

        if (cantJugadas == 0) {
            primeraJugadaMaquina(random.nextInt(1));
        }
        estadoJugada = 1;
        cantJugadas++;
    }

    // Este metodo recibe el cuadro que es clickable por el usuario
    public void onGame(View view) {
        jugadaUsuario.add(view.getTag().toString());
        view.setBackgroundResource(R.mipmap.circle);
        cantJugadas++;
    }

    private void primeraJugadaMaquina(int nr){
        if (nr == 1) {
            Toast.makeText(this,nr+"-ok",Toast.LENGTH_SHORT).show();
            findViewById(R.id.num1).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("00");
        }
        if (nr == 2) {
            findViewById(R.id.num2).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("01");
        }
        if (nr == 3) {
            findViewById(R.id.num3).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("02");
        }

        if (nr == 4) {
            findViewById(R.id.num4).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("10");
        }
        if (nr == 5) {
            findViewById(R.id.num5).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("11");
        }
        if (nr == 6) {
            findViewById(R.id.num6).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("12");
        }

        if (nr == 7) {
            findViewById(R.id.num7).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("20");
        }
        if (nr == 8) {
            findViewById(R.id.num8).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("21");
        }
        if (nr == 9) {
            findViewById(R.id.num9).setBackgroundResource(rutaFicha);
            jugadaMaquina.add("22");
        }
    }
}
