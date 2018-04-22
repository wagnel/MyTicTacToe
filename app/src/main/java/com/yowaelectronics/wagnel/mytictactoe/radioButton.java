package com.yowaelectronics.wagnel.mytictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

public class radioButton extends AppCompatActivity implements View.OnClickListener{
    private Spinner mSpinner;
    private String[] data = { "Dog", "Cat", "Mouse" };
    private ProgressBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        mSpinner = (Spinner) findViewById(R.id.my_spinner);
        barra = findViewById(R.id.progreso);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        findViewById(R.id.my_button).setOnClickListener(this);

        recorrerProgreso();
    }

    private void recorrerProgreso(){
        while (barra.getProgress() < barra.getMax()) {
            barra.incrementProgressBy(1);
            barra.invalidate();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,mSpinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }
}
