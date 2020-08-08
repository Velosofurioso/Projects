package com.velosolucas.app_recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.velosolucas.app_recyclerview.R;
import com.velosolucas.app_recyclerview.activity.RecyclerItemClickListener;
import com.velosolucas.app_recyclerview.activity.adapter.Adapter;
import com.velosolucas.app_recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de Filmes
        this.criarFilmes();

        // Configura o adapter criado
        Adapter adapter = new Adapter(filmes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        // Melhpra a performace definido a criação de uma numero definido do adapter
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter( adapter );

        // Adiciona uma linha abaixo do adapter
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

        // Adicionando Evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = filmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                                "Item Pressionado: " + filme.getTitulo(),
                                                Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = filmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                        "Click longo no filme: "  + filme.getTitulo(),
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    public void criarFilmes(){
        Filme spiderMovie = new Filme("Homem Aranha", "Aventura", "2017");
        this.filmes.add(spiderMovie);

        Filme womanMovie = new Filme("Mulher Maravilha", "Fantasia", "2017");
        this.filmes.add(womanMovie);

        Filme justiceMovie = new Filme("Liga da Justiça", "Ficção", "2017");
        this.filmes.add(justiceMovie);

        Filme usaMovie = new Filme("Capitão America - Guerra civil", "Aventura/Ficção", "2016");
        this.filmes.add(usaMovie);

        Filme itMovie = new Filme("It: A coisa", "Drama/Terror", "2017");
        this.filmes.add(itMovie);

        Filme birdMovie = new Filme("Pica-Pau: o Filme", "Comédia/Animação", "2017");
        this.filmes.add(birdMovie);

        Filme cruiseMovie = new Filme("A Múmia", "Terror", "2017");
        this.filmes.add(cruiseMovie);

        Filme bbMovie = new Filme("A bela e a Fera", "Romance", "2017");
        this.filmes.add(bbMovie);

        Filme gutsMovie = new Filme("Meu Malvado Favorito 3 ", "Comédia", "2017");
        this.filmes.add(gutsMovie);

        Filme carMovie = new Filme("Carros  3 ", "Comédia", "2017");
        this.filmes.add(carMovie);
    }

}