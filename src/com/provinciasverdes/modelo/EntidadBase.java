package com.provinciasverdes.modelo;

public abstract class EntidadBase {
    // Atributo común a todas las entidades
    private int id;

    // Constructor
    public EntidadBase() {
    }

    public EntidadBase(int id) {
        this.id = id;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método abstracto (Obligatorio por POO)
    public abstract void mostrarDatos();
}
