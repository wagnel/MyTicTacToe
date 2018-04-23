package com.yowaelectronics.wagnel.mytictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    private Random random = null;
    private int rutaFichaPlayer1, rutaFichaPlayer2, currentPlayer, cantJugadas;
    private ArrayList<String> jugadaPlayer1, // Almacenaje de cuadros donde juega el primer jugador
                              jugadaPlayer2; // Almacenaje de cuadros donde juega el segundo jugador
    private String ficha, modo;
    private boolean isComputerFirstToPlay;
    private Bundle ref = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        this.ref = getIntent().getBundleExtra("reference");
        this.jugadaPlayer1 = new ArrayList<>();
        this.jugadaPlayer2 = new ArrayList<>();
        this.ficha = ref.getString("ficha");
        this.modo = ref.getString("modo");
        this.random = new Random(9); // 9 cuadros tiene el Tic Tac Toe;
        this.isComputerFirstToPlay = (ref.getString("orden").equals("2")); // [1] Player 1 es el primero, [2] Computer es primero en jugar y retornara True

        //Toast.makeText(this, "Logre entrar por fin", Toast.LENGTH_SHORT).show();

        if ((modo.equals("1_vs_c")) && isComputerFirstToPlay) {
            primeraJugadaMaquina(random.nextInt(5));
        }
    }

    // Este metodo recibe el cuadro que es clickable por el jugador
    public void onGame(View view) {
        // Solo almacena la ruta de la ficha seleccionada
        if (ficha == "circle")
            this.rutaFichaPlayer1 =  R.mipmap.circle;
        else
            this.rutaFichaPlayer2 = R.mipmap.cruz;

        if (currentPlayer == 0) {
            view.setBackgroundResource(rutaFichaPlayer1);
            jugadaPlayer1.add(view.getTag().toString());
            currentPlayer = 1;

        }else{
            view.setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add(view.getTag().toString());
            currentPlayer = 0;
        }

        cantJugadas++;
    }

    private void primeraJugadaMaquina(int nr){
        if (nr == 1) {
            findViewById(R.id.num1).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("00");
        }
        if (nr == 2) {
            findViewById(R.id.num2).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("01");
        }
        if (nr == 3) {
            findViewById(R.id.num3).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("02");
        }

        if (nr == 4) {
            findViewById(R.id.num4).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("10");
        }
        if (nr == 5) {
            findViewById(R.id.num5).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("11");
        }
        if (nr == 6) {
            findViewById(R.id.num6).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("12");
        }

        if (nr == 7) {
            findViewById(R.id.num7).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("20");
        }
        if (nr == 8) {
            findViewById(R.id.num8).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("21");
        }
        if (nr == 9) {
            findViewById(R.id.num9).setBackgroundResource(rutaFichaPlayer2);
            jugadaPlayer2.add("22");
        }
    }
}
