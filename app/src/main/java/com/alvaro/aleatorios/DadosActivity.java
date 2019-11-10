package com.alvaro.aleatorios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class DadosActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTirar;
    private ImageView mostrarDado;
    ArrayList<Integer> dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        instancias();
        acciones();
        dados = new ArrayList<>();
        dados.add(1);
        dados.add(2);
        dados.add(3);
        dados.add(4);
        dados.add(5);
        dados.add(6);
    }

    private void acciones() {
        btnTirar.setOnClickListener(this);
    }

    private void instancias() {
        btnTirar = findViewById(R.id.botonTirar);
        mostrarDado = findViewById(R.id.dadoView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonTirar:

                Integer dadoGanador = dados.get(new Random().nextInt(dados.size()));

                switch (dadoGanador) {
                    case 1:
                        mostrarDado.setImageResource(R.drawable.dado_uno);
                        break;
                    case 2:
                        mostrarDado.setImageResource(R.drawable.dado_dos);
                        break;
                    case 3:
                        mostrarDado.setImageResource(R.drawable.dado_tres);
                        break;
                    case 4:
                        mostrarDado.setImageResource(R.drawable.dado_cuatro_2);
                        break;
                    case 5:
                        mostrarDado.setImageResource(R.drawable.dado_cinco_2);
                        break;
                    case 6:
                        mostrarDado.setImageResource(R.drawable.dado_seis);
                        break;
                }
                break;
        }
    }
}
