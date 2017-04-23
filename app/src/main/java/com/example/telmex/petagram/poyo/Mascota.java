package com.example.telmex.petagram.poyo;

/**
 * Created by telmex on 10/04/2017.
 */

public class Mascota {
    private int id;
    private int foto;
    private String nombre;
    private int cantidadLikes;

    public Mascota() {

    }

    public Mascota(String nombre, int cantidadLikes, int foto) {
        this.nombre = nombre;
        this.cantidadLikes = cantidadLikes;
        this.foto = foto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }
}
