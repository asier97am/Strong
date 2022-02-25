package com.asier.aranda.strong;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    private String identificador;
    private String email;
    private String password;
    private String username;

    private int edad;
    private Float peso;
    private Float altura;

    private String genero;
    private String actividad;
    private String calQuemar;

    public Persona(String email, String password, String username, int edad, Float peso, Float altura, String genero, String actividad, String identificador) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.actividad = actividad;
        this.identificador = identificador;
    }

    public Persona(){}

    protected Persona(Parcel in) {
        identificador = in.readString();
        email = in.readString();
        password = in.readString();
        username = in.readString();
        edad = in.readInt();
        if (in.readByte() == 0) {
            peso = null;
        } else {
            peso = in.readFloat();
        }
        if (in.readByte() == 0) {
            altura = null;
        } else {
            altura = in.readFloat();
        }
        genero = in.readString();
        actividad = in.readString();
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    //FIN GETTERS Y SETTERS


    @Override
    public String toString() {
        return "Persona{" +
                "identificador='" + identificador + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                ", genero='" + genero + '\'' +
                ", actividad='" + actividad + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(identificador);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(username);
        dest.writeInt(edad);
        if (peso == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(peso);
        }
        if (altura == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(altura);
        }
        dest.writeString(genero);
        dest.writeString(actividad);
    }


    public int pasosDiariosRecomendados(){
        int pasosDiariosRecomendados = 0;

        if(genero.equalsIgnoreCase("Mujer") && actividad.equalsIgnoreCase("Activo")){
            pasosDiariosRecomendados = 10000;
            calQuemar = "2000 - 2300";
        }

        else if(genero.equalsIgnoreCase("Mujer") && actividad.equalsIgnoreCase("Principiante")){
            pasosDiariosRecomendados = 7000;
            calQuemar = "1600 - 1750";
        }

        else if(genero.equalsIgnoreCase("Hombre") && actividad.equalsIgnoreCase("Activo")){
            calQuemar = "2300 - 2500";
            pasosDiariosRecomendados = 10000;
        }

        else if(genero.equalsIgnoreCase("Hombre") && actividad.equalsIgnoreCase("Principiante")){
            calQuemar = "2000-2200";
            pasosDiariosRecomendados = 7000;
        }

        return pasosDiariosRecomendados;
    }


    public float pesoIdeal(){
        Float pesoIdeal;

        if(genero.equalsIgnoreCase("Mujer")){

            pesoIdeal = ((altura - 100) - (altura - 150) / 2);

        }else{
            pesoIdeal= ((altura - 100) - (altura - 150) / 4);
        }

        return pesoIdeal;

    }


    public String getCaloriasAQuemar(){
        return calQuemar;
    }


}