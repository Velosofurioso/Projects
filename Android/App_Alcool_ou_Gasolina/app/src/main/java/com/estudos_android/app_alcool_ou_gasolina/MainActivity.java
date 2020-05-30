package com.estudos_android.app_alcool_ou_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText gasolina, alcool;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolina = findViewById(R.id.editTGasolina);
        alcool = findViewById(R.id.editTAlcool);
        resultado = findViewById(R.id.resultado);
    }

    public void calcularMelhorOpcao(View view) {

        String gasolinaPreco = gasolina.getText().toString();
        String alcoolPreco = alcool.getText().toString();

        if (gasolinaPreco == null || alcoolPreco == null
                || gasolinaPreco.equalsIgnoreCase("") || alcoolPreco.equalsIgnoreCase("")) {
            resultado.setText("PREENCHA TODOS OS CAMPOS!");
        } else {

            Double valorGasolina = Double.parseDouble(gasolinaPreco);
            Double valorAlcool = Double.parseDouble(alcoolPreco);

            if ((valorAlcool / valorGasolina) >= 0.7) {
                resultado.setText("É MELHOR USAR GASOLINA");
            } else {
                resultado.setText("É MELHOR USAR ALCOOL");

            }

        }
    }
}
