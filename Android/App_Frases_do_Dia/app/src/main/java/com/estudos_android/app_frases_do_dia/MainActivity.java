package com.estudos_android.app_frases_do_dia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void gerarNovaFrase(View view){

            String[] frases = {
                    " Enfrente os problemas e leve a melhor!", "Dê mais atenção ao que você tem de bom na sua vida",
                    "Para chegar ao topo, o que importa é começar!", "De nada adianta ter sonhos, se você não se empenhar em correr atrás",
                    "Levanta, sacode a poeira, dá a volta por cima.", "Nem todos os dias são bons, mas há algo bom em cada dia.",
                    "Suba o primeiro degrau com fé. Não é necessário que você veja toda a escada, apenas dê o primeiro passo.", "Toda manhã você tem duas escolhas: continuar dormindo com seus sonhos ou acordar e persegui-los!"
            };
            int numero = new Random().nextInt(frases.length);

            TextView txt = findViewById(R.id.txt_msg);

            txt.setText(frases[numero]);


        }


}
