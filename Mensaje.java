package com.example.cerradura;

public class Mensaje {

    private String showMensaje;
    private String nomMensaje;
    private String imgMensPerfil;
    private String type_mensaje;
    private String hora;

    public Mensaje(String showMensaje, String nomMensaje, String imgMensPerfil, String type_mensaje, String hora) {
        this.showMensaje = showMensaje;
        this.nomMensaje = nomMensaje;
        this.imgMensPerfil = imgMensPerfil;
        this.type_mensaje = type_mensaje;
        this.hora = hora;
    }

    public Mensaje() {

    }

    public String getShowMensaje() {
        return showMensaje;
    }

    public void setShowMensaje(String showMensaje) {
        this.showMensaje = showMensaje;
    }

    public String getNomMensaje() {
        return nomMensaje;
    }

    public void setNomMensaje(String nomMensaje) {
        this.nomMensaje = nomMensaje;
    }

    public String getImgMensPerfil() {
        return imgMensPerfil;
    }

    public void setImgMensPerfil(String imgMensPerfil) {
        this.imgMensPerfil = imgMensPerfil;
    }

    public String getType_mensaje() {
        return type_mensaje;
    }

    public void setType_mensaje(String type_mensaje) {
        this.type_mensaje = type_mensaje;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
