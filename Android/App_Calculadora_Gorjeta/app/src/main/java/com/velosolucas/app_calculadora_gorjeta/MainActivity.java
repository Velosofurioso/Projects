package com.velosolucas.app_calculadora_gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editValor           = findViewById(R.id.editValor);
        this.textTotal           = findViewById(R.id.textTotal);
        this.textGorjeta         = findViewById(R.id.textGorjeta);
        this.textPorcentagem     = findViewById(R.id.textPorcentangem);
        this.seekBarGorjeta      = findViewById(R.id.seekBarGorjeta);

        this.seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        String valorRecuperado = this.editValor.getText().toString();

        if("".equals(valorRecuperado) || valorRecuperado==null)
            Toast.makeText(getApplicationContext(),"Digite um valor", Toast.LENGTH_SHORT).show();

        else{
            // Converte o valor em String para Double
            double valorDigitado = Double.valueOf(valorRecuperado);

            // Calcula o valor da gorjeta
            double valorGorjeta = valorDigitado * (porcentagem / 100);
            double valorTotal = valorDigitado + valorGorjeta;

            this.textGorjeta.setText("R$ " + Math.round(valorGorjeta));
            this.textTotal.setText("R$ " + Math.round(valorTotal));

        }


    }
}