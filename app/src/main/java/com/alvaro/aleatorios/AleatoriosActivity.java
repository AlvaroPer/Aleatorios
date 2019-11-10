package com.alvaro.aleatorios;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AleatoriosActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioButton sinRango, conRango;
    private EditText rangoMinimo, rangoMaximo, numeroDecimales, numeroTotales;
    private CheckBox permitirDecimales;
    private Switch repetirNumeros;
    private ImageButton btnCohete;
    private TextView mostrarNumeros;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorios);
        instancias();
        acciones();
    }

    private void acciones() {
        btnCohete.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        sinRango.setOnCheckedChangeListener(this);
        conRango.setOnCheckedChangeListener(this);
        permitirDecimales.setOnCheckedChangeListener(this);
        repetirNumeros.setOnCheckedChangeListener(this);
    }

    private void instancias() {
        sinRango = findViewById(R.id.radioSin);
        conRango = findViewById(R.id.radioCon);
        rangoMinimo = findViewById(R.id.editMinimo);
        rangoMaximo = findViewById(R.id.editMaximo);
        numeroDecimales = findViewById(R.id.editNumeroDecimales);
        numeroTotales = findViewById(R.id.editNumeroTotales);
        permitirDecimales = findViewById(R.id.checkBoxDecimales);
        repetirNumeros = findViewById(R.id.switchRepetirNumeros);
        btnCohete = findViewById(R.id.botonCohete);
        mostrarNumeros = findViewById(R.id.TexViewNumeros);
        radioGroup = findViewById(R.id.grupoRadios);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean b) {
        if (b){
            numeroDecimales.setEnabled(true);
        }else {
            numeroDecimales.setEnabled(false);
            numeroTotales.setEnabled(false);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        switch (radioGroup.getId()) {
            case R.id.grupoRadios:
                switch (i) {
                    case R.id.radioSin:
                        rangoMinimo.setEnabled(false);
                        rangoMaximo.setEnabled(false);
                        break;
                    case R.id.radioCon:
                        rangoMinimo.setEnabled(true);
                        rangoMaximo.setEnabled(true);

                        int inicial=0, cantidad= (numeroTotales.getInputType()), rango = (rangoMaximo.getInputType());
                        int aleatorios[] = new int[cantidad];

                        aleatorios[inicial]=(int) (Math.random()*rango);
                        for (inicial=(rangoMinimo.getInputType()); inicial<cantidad; i++) {
                            aleatorios[inicial] = (int) (Math.random()*rango);
                            for (int j=0; j<inicial; j++) {
                                if (aleatorios[inicial]==aleatorios[j]){
                                    inicial--;
                                }
                            }
                        }
                        for (int k=0; k<cantidad; k++) {
                            mostrarNumeros.setText(aleatorios[k]+"\n");
                        }
                        break;
                }
                break;
        }
    }
}
