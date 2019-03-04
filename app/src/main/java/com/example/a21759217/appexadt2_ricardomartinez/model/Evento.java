package com.example.a21759217.appexadt2_ricardomartinez.model;

import java.io.Serializable;

public class Evento implements Serializable {

    private int id;
    private String nombre;
    private String municipio;
    private String descripcion;
    private String fecha;
    private String hora;

    public Evento(int id, String nombre, String municipio, String descripcion, String fecha, String hora) {
        this.id = id;
        this.nombre = nombre;
        this.municipio = municipio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Evento(String nombre, String municipio, String descripcion, String fecha, String hora) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
}
