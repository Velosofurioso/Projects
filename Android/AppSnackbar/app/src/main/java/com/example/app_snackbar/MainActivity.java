package com.example.app_snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.buttonAbrir);

        buttonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Mostra somente a mensagem igual ao Toast
                //Snackbar.make(view, "Snackbar sem ação(Botão)", Snackbar.LENGTH_LONG).show();

                // Mostra a mensagem com um botão para disparar um evento
                Snackbar snackbar = Snackbar.make(view, "Snackbar com ação", Snackbar.LENGTH_LONG)
                        .setAction("Confirmar", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                buttonAbrir.setText("Botão abrir alterado");
                            }

                        });

                // Altera a cor do botão do Snackbar e o mostra
                snackbar.setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
            }
        });
    }


    private void abrirSnackbar(View view){

    }


}