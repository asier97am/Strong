package com.asier.aranda.strong;

public class Persona {
    private String email;
    private String password;
    private String username;
    private String apellido;

    private int edad;
    private Float peso;
    private Float altura;

    private boolean genero;
    private boolean actividad;


    public Persona(String email, String password, String username, String apellido, int edad, Float peso, Float altura, boolean genero, boolean actividad) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.apellido = apellido;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.actividad = actividad;
    }

    public Persona(){}

    //INICIO GETTERS Y SETTERS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public boolean isActividad() {
        return actividad;
    }

    public void setActividad(boolean actividad) {
        this.actividad = actividad;
    }

    //FIN GETTERS Y SETTERS




}
