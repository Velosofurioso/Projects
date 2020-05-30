package com.estudos_android.app_pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }   

    public void selecionadoPedra(View view) {
        opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView image = findViewById(R.id.imgSelecionada);

        int num = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};

        String opcoesApp = opcoes[num];

        switch (opcoesApp) {

            case "pedra":
                image.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                image.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                image.setImageResource(R.drawable.tesoura);
                break;
        }

        TextView txt = findViewById(R.id.status);

        if (("pedra".equals(opcoesApp) && "tesoura".equals(opcaoSelecionada))
                || ("papel".equals(opcoesApp) && "pedra".equals(opcaoSelecionada))
                || ("tesoura".equals(opcoesApp) && "papel".equals(opcaoSelecionada))) {

            txt.setText("O APP GANHOU!!!!");

        } else if (("pedra".equals(opcaoSelecionada) && "tesoura".equals(opcoesApp))
                || ("papel".equals(opcaoSelecionada) && "pedra".equals(opcoesApp))
                || ("tesoura".equals(opcaoSelecionada) && "papel".equals(opcoesApp))) {

            txt.setText("O VOCÊ GANHOU!!!!");
        } else {

            txt.setText("EMPATOU!!!!");
        }


    }


}
