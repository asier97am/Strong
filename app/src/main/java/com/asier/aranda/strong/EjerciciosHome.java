package com.asier.aranda.strong;

public class EjerciciosHome {
    private String ejercicio,descripcion;
    private int fotoEjercicio;

    public EjerciciosHome(String ejercicio, String descripcion, int fotoEjercicio) {
        this.ejercicio = ejercicio;
        this.descripcion = descripcion;
        this.fotoEjercicio = fotoEjercicio;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFotoEjercicio() {
        return fotoEjercicio;
    }

    public void setFotoEjercicio(int fotoEjercicio) {
        this.fotoEjercicio = fotoEjercicio;
    }
}
