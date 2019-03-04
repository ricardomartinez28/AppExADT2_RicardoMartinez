package com.example.a21759217.appexadt2_ricardomartinez.model;

public class Municipio {

    private int id;
    private String nombre;

    public Municipio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Municipio(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

