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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioBtnClick(View view) {
        RadioButton circle = findViewById(R.id.radioBtnCircle);
        RadioButton cruz = findViewById(R.id.radioBtnCruz);

        if (circle.isChecked())
            cruz.setEnabled(false);
        else if (cruz.isChecked())
            circle.setEnabled(false);
    }

    public void playGame(View view) {
        RadioButton circle = findViewById(R.id.radioBtnCircle);
        RadioButton cruz = findViewById(R.id.radioBtnCruz);

        if (!circle.isChecked() && !cruz.isChecked()){
            Toast.makeText(getApplicationContext(),"Debe seleccionar una ficha",Toast.LENGTH_SHORT).show();

        }else{

            CheckBox first = findViewById(R.id.chkFirst);

            if (!first.isChecked())
                Toast.makeText(getApplicationContext(),"Eres segundo en jugar",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,Juego.class);
            startActivity(intent);
        }
    }
}
