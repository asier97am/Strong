package com.asier.aranda.strong;

public class EjerciciosHome {
    private String ejercicio,descripcion,descripcion2;
    private int fotoEjercicio;

    public EjerciciosHome(String ejercicio, String descripcion,String descripcion2, int fotoEjercicio) {
        this.ejercicio = ejercicio;
        this.descripcion = descripcion;
        this.descripcion2 = descripcion2;
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

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public int getFotoEjercicio() {
        return fotoEjercicio;
    }

    public void setFotoEjercicio(int fotoEjercicio) {
        this.fotoEjercicio = fotoEjercicio;
    }
}
