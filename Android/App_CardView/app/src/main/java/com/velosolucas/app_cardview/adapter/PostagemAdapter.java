package com.velosolucas.app_cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.velosolucas.app_cardview.R;
import com.velosolucas.app_cardview.model.Postagem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {
    private List<Postagem> posts;

    public PostagemAdapter(List<Postagem> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cardview, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomePostagem.setText(posts.get(position).getNome());
        holder.postagemText.setText(posts.get(position).getPostagem());
        holder.imagePostagem.setImageResource(posts.get(position).getImage());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nomePostagem;
        private TextView postagemText;
        private ImageView imagePostagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomePostagem = itemView.findViewById(R.id.textNome);
            postagemText = itemView.findViewById(R.id.txtPostagem);
            imagePostagem = itemView.findViewById(R.id.imgPostagem);
        }
    }
}
