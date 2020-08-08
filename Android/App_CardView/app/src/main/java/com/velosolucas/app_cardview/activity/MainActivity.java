package com.velosolucas.app_cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.velosolucas.app_cardview.R;
import com.velosolucas.app_cardview.adapter.PostagemAdapter;
import com.velosolucas.app_cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerPostagem;
    private List<Postagem> post = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerView);

        // Define o layout como Linear Layout
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        // Cria um efeito de slides com os dados da lista
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/

        // Cria um layout em formato de grid como uma tabela na tela
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);


        recyclerPostagem.setLayoutManager(layoutManager);

        this.prepararPostagens();

        PostagemAdapter adapterCadView = new PostagemAdapter(post);

        // Define o adapter
        recyclerPostagem.setAdapter(adapterCadView);

    }

    public void prepararPostagens(){

        Postagem p1 = new Postagem("Lucas Veloso", "#tbt Viajem Legal!", R.drawable.imagem1);
        this.post.add(p1);

        Postagem p2 = new Postagem("Hotel Lv", "Viaje, aproveite nossos descontos!", R.drawable.imagem2);
        this.post.add(p2);

        Postagem p3 = new Postagem("Maria Luiza", "#Paris!!", R.drawable.imagem3);
        this.post.add(p3);

        Postagem p4 = new Postagem("Marcos Paulo", "Que foto linda!", R.drawable.imagem4);
        this.post.add(p4);
    }
}