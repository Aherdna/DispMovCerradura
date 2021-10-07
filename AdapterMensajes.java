package com.example.cerradura;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterMensajes extends RecyclerView.Adapter<HolderMensaje> {

    private List<Mensaje> lsitMensaje = new ArrayList<>();
    private Context c;

    public AdapterMensajes(Context c) {
        this.c=c;
    }

    public void addMensaje(Mensaje m) {
        lsitMensaje.add(m);
        notifyItemInserted(lsitMensaje.size());
    }


    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes, parent, false);

        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holder, int position) {
        holder.getNomMensaje().setText(lsitMensaje.get(position).getNomMensaje());
        holder.getShowMensaje().setText(lsitMensaje.get(position).getShowMensaje());
        holder.getHora().setText(lsitMensaje.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return lsitMensaje.size();
    }
}
