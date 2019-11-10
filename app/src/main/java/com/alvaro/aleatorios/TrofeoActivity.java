package com.alvaro.aleatorios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class TrofeoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAgregar, btnGanador;
    private TextView introNombre, mostGanador;
    ArrayList<String> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);
        instancias();
        acciones();
        personas = new ArrayList<>();
    }

    private void acciones() {
        btnAgregar.setOnClickListener(this);
        btnGanador.setOnClickListener(this);
    }

    private void instancias() {
        btnAgregar = findViewById(R.id.botonAgregar);
        btnGanador = findViewById(R.id.botonGanador);
        introNombre = findViewById(R.id.IntroducirNombre);
        mostGanador = findViewById(R.id.mostrarGanador);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonAgregar:

                personas.add(introNombre.getText().toString());
                introNombre.setText("");
                break;

            case R.id.botonGanador:

                String ganador = personas.get(new Random().nextInt(personas.size()));
                mostGanador.setText(ganador);
                break;
        }
    }
}
