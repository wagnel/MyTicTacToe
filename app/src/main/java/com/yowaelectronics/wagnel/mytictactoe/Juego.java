package com.yowaelectronics.wagnel.mytictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    private boolean isComputerFirstToPlay;
    private int rutaFichaPlayer1, rutaFichaPlayer2, currentPlayer, cantJugadas;
    private Random random = null;
    private String ficha, modo;
    private Bundle ref = null;
    private ArrayList<String> jugadasPlayer1 = new ArrayList<>();
    private ArrayList<String> jugadasPlayer2 = new ArrayList<>();
    private ArrayList<String> ganada1,ganada2,ganada3,ganada4,ganada5,ganada6,ganada7,ganada8;
    private ArrayList<Integer> jugadas = new ArrayList<>();
    private int[] jugadasFaltantes = {1,2,3,4,5,6,7,8,9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        this.ref = getIntent().getBundleExtra("reference");
        this.ficha = ref.getString("ficha"); // [Circle] or [Cruz]
        this.modo = ref.getString("modo"); // [Player 1 vs Player2] or [Player 1 vs Computer]
        this.random = new Random();
        this.isComputerFirstToPlay = (ref.getString("orden").equals("2")); // [1] Player 1 es el primero, [2] Computer es primero en jugar y retornara True
        this.ganada1 = new ArrayList<>(3); // 00-01-02 [1-2-3] -
        this.ganada2 = new ArrayList<>(3); // 00-10-20 [1-4-7] -
        this.ganada3 = new ArrayList<>(3); // 00-11-22 [1-5-9] \
        this.ganada4 = new ArrayList<>(3); // 01-11-21 [2-5-8] |
        this.ganada5 = new ArrayList<>(3); // 02-11-20 [3-5-7] /
        this.ganada6 = new ArrayList<>(3); // 02-12-22 [3-6-9] |
        this.ganada7 = new ArrayList<>(3); // 10-11-12 [4-5-6] -
        this.ganada8 = new ArrayList<>(3); // 20-21-22 [7-8-9] -

        //for (int i = 1; i <= 9; i++)
            //this.jugadas.add(i);

        prepararFichas();
        verificarTurnoComputer();
    }

    // Este metodo solo almacena la ruta de la ficha seleccionada
    private void prepararFichas(){
        if (ficha.equals("circle")) {
            this.rutaFichaPlayer1 = R.mipmap.circle;
            this.rutaFichaPlayer2 = R.mipmap.cruz;
        } else {
            this.rutaFichaPlayer1 = R.mipmap.cruz;
            this.rutaFichaPlayer2 = R.mipmap.circle;
        }
    }

    // Este metodo verifica si el dispositivo es el primero en jugar [En Desarrollo...]
    private void verificarTurnoComputer(){
        if (isComputerFirstToPlay) {
            int nextPosition = random.nextInt(8)+1;

            for (int n = 0; n < jugadasFaltantes.length; n++){
                if(nextPosition == jugadasFaltantes[n]){
                    jugadasFaltantes[n] = 0;
                    nextPosition = random.nextInt(8)+1;
                    break;
                }
                else if (n == 8){
                    Toast.makeText(this,"Verificar quien fue que gano",Toast.LENGTH_SHORT).show();
                    break;
                }
            }

            jugadaDeLaMaquina(nextPosition);
            currentPlayer = 0;
        }
    }

    // Este metodo recibe el cuadro que es clickable por el jugador
    public void onGame(View view) {

        prepararFichas();

        if (currentPlayer == 0) {
            view.setBackgroundResource(rutaFichaPlayer1);
            jugadasPlayer1.add(view.getTag().toString());
            verificarGanada("p1",view.getTag().toString());
            currentPlayer = 1;
            verificarTurnoComputer();

        }else{
            view.setBackgroundResource(rutaFichaPlayer2);
            jugadasPlayer2.add(view.getTag().toString());
            verificarGanada("p2",view.getTag().toString());
            currentPlayer = 0;
        }

        cantJugadas++;
    }

    private void verificarGanada(String player, String cuadro) {
        if (cuadro.equals("00") || cuadro.equals("01") || cuadro.equals("02")) ganada1.add(player);
        if (cuadro.equals("00") || cuadro.equals("10") || cuadro.equals("20")) ganada2.add(player);
        if (cuadro.equals("00") || cuadro.equals("11") || cuadro.equals("22")) ganada3.add(player);
        if (cuadro.equals("01") || cuadro.equals("11") || cuadro.equals("21")) ganada4.add(player);
        if (cuadro.equals("02") || cuadro.equals("11") || cuadro.equals("20")) ganada5.add(player);
        if (cuadro.equals("02") || cuadro.equals("12") || cuadro.equals("22")) ganada6.add(player);
        if (cuadro.equals("10") || cuadro.equals("11") || cuadro.equals("12")) ganada7.add(player);
        if (cuadro.equals("20") || cuadro.equals("21") || cuadro.equals("22")) ganada8.add(player);
        obtenerGanador();
    }
    private void obtenerGanador(){
        if (cantJugadas == 4){
            //Toast.makeText(this,ganada1.get(0)+" : "+ganada1.get(1)+" : "+ganada1.get(1), Toast.LENGTH_SHORT).show();
            if (ganada1.get(0).equals("p1") && ganada1.get(1).equals("p1") && ganada1.get(1).equals("p1"))
                Toast.makeText(this,"Player 1 es el ganador! Felicidades", Toast.LENGTH_SHORT).show();
            else if (ganada1.get(0).equals("p2") && ganada1.get(1).equals("p2") && ganada1.get(1).equals("p2"))
                Toast.makeText(this,"Player 2 es el ganador! Felicidades", Toast.LENGTH_SHORT).show();

            /*if (ganada2.get(0) == "p1" && ganada2.get(1) == "p1" && ganada2.get(2) == "p1") Toast.makeText(this,p1+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show(); else Toast.makeText(this,p2+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show();
            if (ganada3.get(0) == "p1" && ganada3.get(1) == "p1" && ganada3.get(2) == "p1") Toast.makeText(this,p1+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show(); else Toast.makeText(this,p2+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show();
            if (ganada4.get(0) == "p1" && ganada4.get(1) == "p1" && ganada4.get(2) == "p1") Toast.makeText(this,p1+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show(); else Toast.makeText(this,p2+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show();
            if (ganada5.get(0) == "p1" && ganada5.get(1) == "p1" && ganada5.get(2) == "p1") Toast.makeText(this,p1+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show(); else Toast.makeText(this,p2+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show();
            if (ganada6.get(0) == "p1" && ganada6.get(1) == "p1" && ganada6.get(2) == "p1") Toast.makeText(this,p1+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show(); else Toast.makeText(this,p2+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show();
            if (ganada7.get(0) == "p1" && ganada7.get(1) == "p1" && ganada7.get(2) == "p1") Toast.makeText(this,p1+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show(); else Toast.makeText(this,p2+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show();
            if (ganada8.get(0) == "p1" && ganada8.get(1) == "p1" && ganada8.get(2) == "p1") Toast.makeText(this,p1+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show(); else Toast.makeText(this,p2+"es el ganador! Felicidades", Toast.LENGTH_SHORT).show();
            */
        }
    }

    // Jugada principal de la maquina
    private void jugadaDeLaMaquina(int nr){
        if (nr == 1) subJugadaMaquina(R.id.num1,"00",1);
        if (nr == 2) subJugadaMaquina(R.id.num2,"01",2);
        if (nr == 3) subJugadaMaquina(R.id.num3,"02",3);

        if (nr == 4) subJugadaMaquina(R.id.num4,"10",4);
        if (nr == 5) subJugadaMaquina(R.id.num5,"11",5);
        if (nr == 6) subJugadaMaquina(R.id.num6,"12",6);

        if (nr == 7) subJugadaMaquina(R.id.num7,"20",7);
        if (nr == 8) subJugadaMaquina(R.id.num8,"21",8);
        if (nr == 9) subJugadaMaquina(R.id.num9,"22",9);

        //jugadaPlayers[cantJugadas] = nr;
    }
    private void subJugadaMaquina(int id, String position, int num){
        findViewById(id).setBackgroundResource(rutaFichaPlayer2);
        cantJugadas++;
    }
}
