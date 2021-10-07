package com.example.cerradura;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;


public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView nomMensaje;
    private TextView showMensaje;
    private TextView hora;
    private CircleImageView imgMensPerfil;


    public HolderMensaje(@NonNull View itemView) {
        super(itemView);

        nomMensaje = (TextView) itemView.findViewById(R.id.nomMensaje);
        showMensaje = (TextView) itemView.findViewById(R.id.showMensaje);
        hora = (TextView) itemView.findViewById(R.id.hora);
        imgMensPerfil = (CircleImageView) itemView.findViewById(R.id.imgMensPerfil);
    }

    public TextView getNomMensaje() {
        return nomMensaje;
    }

    public void setNomMensaje(TextView nomMensaje) {
        this.nomMensaje = nomMensaje;
    }

    public TextView getShowMensaje() {
        return showMensaje;
    }

    public void setShowMensaje(TextView showMensaje) {
        this.showMensaje = showMensaje;
    }

    public TextView getHora() {
        return hora;
    }

    public void setHora(TextView hora) {
        this.hora = hora;
    }

    public CircleImageView getImgMensPerfil() {
        return imgMensPerfil;
    }

    public void setImgMensPerfil(CircleImageView imgMensPerfil) {
        this.imgMensPerfil = imgMensPerfil;
    }
}
