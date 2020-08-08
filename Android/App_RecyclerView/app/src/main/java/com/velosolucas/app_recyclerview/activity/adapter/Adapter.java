package com.velosolucas.app_recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.velosolucas.app_recyclerview.R;
import com.velosolucas.app_recyclerview.activity.model.Filme;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista){
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Neste passo é criado somente o template da tela sem os seus dados

        // Cria um objeto do tipo VIew para ser retornado e visualizado a partir do layout adapter_lista
        View itemLista = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Neste passo é inserido os dados no template de tela criado no metodo onCreateViewHolder
        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTitulo());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    @Override
    public int getItemCount() {
        // Neste passo é definido a quantidade de itens que irá ser criado na tela
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Usa a view recebida para acessar o id de cada elemento
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
