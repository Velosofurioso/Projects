package com.example.app_fragments.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app_fragments.R;
import com.example.app_fragments.fragments.ContatosFragment;
import com.example.app_fragments.fragments.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversas, buttonContatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Remove a sombra do Actionbar
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();
        contatosFragment = new ContatosFragment();

        buttonConversas = findViewById(R.id.buttonConversas);
        buttonContatos = findViewById(R.id.buttonContatos);

        // Configura objeto para o Fragmento
        FragmentTransaction fragmentTransactionContato = getSupportFragmentManager().beginTransaction();
        fragmentTransactionContato.replace(R.id.frameConteudo, conversasFragment);
        fragmentTransactionContato.commit();

        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Configura objeto para o Fragmento
                FragmentTransaction fragmentTransactionContato = getSupportFragmentManager().beginTransaction();
                fragmentTransactionContato.replace(R.id.frameConteudo, contatosFragment);
                fragmentTransactionContato.commit();
            }
        });

        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Configura objeto para o Fragmento
                FragmentTransaction fragmentTransactionContato = getSupportFragmentManager().beginTransaction();
                fragmentTransactionContato.replace(R.id.frameConteudo, conversasFragment);
                fragmentTransactionContato.commit();
            }
        });

    }
}