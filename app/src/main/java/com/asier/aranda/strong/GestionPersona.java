package com.asier.aranda.strong;

public class GestionPersona {
    private float peso, altura;
    int edad;
    private String genero, actividad;

    public GestionPersona(float peso, int edad, float altura, String genero, String actividad){
        this.peso = peso;
        this.edad = edad;
        this.altura = altura;
        this.actividad = actividad;
        this.genero = genero;
    }
    public GestionPersona(){}

    //Esto es una forma chorra de como comprobar la edad
    public boolean comprobacionEdad(int datoEdad){
        boolean entrada = false;
        if(datoEdad >= 18 && datoEdad < 80){
           entrada = true;
        }
        return entrada;
    }

    //GETTERS AND SETTERS
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "GestionPersona{" +
                "peso = " + peso +
                ", altura = " + altura +
                ", edad = " + edad +
                ", genero = '" + genero + '\'' +
                ", actividad = '" + actividad + '\'' +
                '}';
    }
}
