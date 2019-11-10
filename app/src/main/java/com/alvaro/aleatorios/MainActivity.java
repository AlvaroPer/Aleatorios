package com.alvaro.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnAleatorios, btnDados, btnTrofeo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnAleatorios.setOnClickListener(this);
        btnDados.setOnClickListener(this);
        btnTrofeo.setOnClickListener(this);
    }

    private void instancias() {
        btnAleatorios = findViewById(R.id.aleatorios);
        btnDados = findViewById(R.id.dados);
        btnTrofeo = findViewById(R.id.trofeo);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aleatorios:

                Intent iAleatorios = new Intent(getApplicationContext(), AleatoriosActivity.class);
                startActivity(iAleatorios);

                break;
            case R.id.dados:

                Intent iDados = new Intent(getApplicationContext(), DadosActivity.class);
                startActivity(iDados);

                break;
            case R.id.trofeo:

                Intent iTrofeo = new Intent(getApplicationContext(), TrofeoActivity.class);
                startActivity(iTrofeo);

                break;
        }
    }
}
