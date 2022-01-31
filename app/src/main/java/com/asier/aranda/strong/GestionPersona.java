package com.asier.aranda.strong;

public class GestionPersona {
    private float peso, altura;
    int edad;
    private String genero, actividad;

    public GestionPersona(float peso, int edad, float altura){
        this.peso = peso;
        this.edad = edad;
        this.altura = altura;
    }
    public GestionPersona(){}


    public boolean comprobacionEdad(int datoEdad){
        boolean entrada = false;
        if(datoEdad >= 18 && datoEdad < 80){
           entrada = true;
        }

        return entrada;
    }


}
