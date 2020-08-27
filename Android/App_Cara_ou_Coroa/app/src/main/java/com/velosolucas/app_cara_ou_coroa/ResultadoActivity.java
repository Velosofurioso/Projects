package com.velosolucas.app_cara_ou_coroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {
    private ImageView image;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        image = findViewById(R.id.image_result);
        btnVoltar = findViewById(R.id.button_voltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Encerra esta activity
                finish();
            }
        });

        this.loadDataFromActivity();
    }


    private void loadDataFromActivity() {

        Bundle extras = getIntent().getExtras();

        if(extras != null && !extras.isEmpty()){
            if(extras.getInt("numero") <=250){
                image.setImageResource(R.drawable.moeda_cara);
            }

            else{
                image.setImageResource(R.drawable.moeda_coroa);
            }
        }
    }


}