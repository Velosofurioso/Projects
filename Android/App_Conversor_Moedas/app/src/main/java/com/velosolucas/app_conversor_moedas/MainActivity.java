package com.velosolucas.app_conversor_moedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.resultDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.resultEuro = findViewById(R.id.text_euro);
        this.mViewHolder.inputValor = findViewById(R.id.edit_valor);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.resultEuro.setText("0");
        this.mViewHolder.resultDolar.setText("0");
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_calculate){
            String value = this.mViewHolder.inputValor.getText().toString();

            if("".equals(value)){
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_SHORT).show();
                this.clearValues();
            }

            else{
                Double real = Double.valueOf(value);

                this.mViewHolder.resultDolar.setText(String.format("%.2f", (real / 4)));
                this.mViewHolder.resultEuro.setText(String.format("%.2f", (real / 5)));
            }
        }
    }

    private static class ViewHolder{
        TextView resultDolar, resultEuro;
        EditText inputValor;
        Button buttonCalculate;
    }
}