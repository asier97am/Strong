package com.asier.aranda.strong.bbddUser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.asier.aranda.strong.Persona;

public class DataPersona extends SQLiteOpenHelper {
    private static final String BD_NAME = "persona.db";
    private static final int BD_VERSION = 1;
    public static final String TB_NAME = "t_persona";

    public DataPersona(@Nullable Context context) {
        super(context, BD_NAME, null, BD_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TB_NAME + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "correo TEXT NOT NULL, " +
                "nombre TEXT NOT NULL," +
                "password TEXT NOT NULL," +
                "edad INTEGER NOT NULL," +
                "altura TEXT,"+
                "peso TEXT," +
                "genero TEXT, " +
                "actividad TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void borrar(){
        SQLiteDatabase db = getWritableDatabase();


            db.execSQL("DELETE FROM t_persona where id = 1");
            db.close();

    }

    public void agregarUsuario(Persona p){
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            db.execSQL("INSERT INTO t_persona (correo, nombre, password, edad, altura, peso, genero, actividad) VALUES ('"+ p.getEmail() +
                    "', '" + p.getUsername() + "', '" + p.getPassword() + "'," + p.getEdad() + " ," + p.getAltura() + "," + p.getPeso() + " , '" + p.getGenero() + "', '" + p.getActividad() +"')");
            db.close();
        }
    }

    public void cambioDatosPersona(Persona p){
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("UPDATE t_persona SET edad = " + p.getEdad() +", peso = '" + p.getPeso() + "', altura = '"
                + p.getAltura() + "', genero = '" + p.getGenero() + "', actividad = '" + p.getActividad() + "', nombre = '" + p.getUsername() +"', correo = '" + p.getEmail() + "'"
                + " where id = " + p.getIdentificador());

        db.close();
    }



    @SuppressLint("Range")
    public Persona busquedaDatosPersona(String user, String pass){
        Persona p = new Persona();
        SQLiteDatabase db = getWritableDatabase();

        String dato = "";
        Cursor cursor = db.rawQuery("select id, correo, nombre, altura, peso, genero, actividad, edad from t_persona where nombre like '" + user + "' and password like '" + pass + "'", null);

        if(cursor.moveToFirst()){

            dato = cursor.getString(cursor.getColumnIndex("id"));
            p.setIdentificador(dato);

            dato = cursor.getString(cursor.getColumnIndex("correo"));
            p.setEmail(dato);

            dato = cursor.getString(cursor.getColumnIndex("nombre"));
            p.setUsername(dato);

            dato = cursor.getString(cursor.getColumnIndex("altura"));
            p.setAltura(Float.parseFloat(dato));

            dato = cursor.getString(cursor.getColumnIndex("peso"));
            p.setPeso(Float.parseFloat(dato));

            dato = cursor.getString(cursor.getColumnIndex("genero"));
            p.setGenero(dato);

            dato = cursor.getString(cursor.getColumnIndex("actividad"));
            p.setActividad(dato);

            dato = cursor.getString(cursor.getColumnIndex("edad"));
            p.setEdad(Integer.parseInt(dato));

            cursor.close();

        }else{
            return null;
        }


        return p;

    }
    @SuppressLint("Range")
    public void existenciaPersona(){

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select count(*) from t_persona", null);

        cursor.moveToFirst();
        Integer i = Integer.parseInt(cursor.getString(0));

        if(i == 0){
            creacionAdmin();
        }

    }

    @SuppressLint("Range")
    public boolean busquedaDatosExistencia(String user, String pass){

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select nombre, password from t_persona where nombre like '" + user + "' and password like '" + pass + "'", null);

        if(cursor.moveToFirst()){
            return true;
        }else {

            return false;
        }
    }

    public void creacionAdmin(){
        SQLiteDatabase db = getWritableDatabase();
        String correoAdmin = "prueba@gmail.com";
        String nombre = "admin";
        String password = "1234";
        Integer edad = 23;
        String altura = "1.85";
        String peso = "1.65";
        String genero = "Hombre";
        String actividad = "Principiante";

        db.execSQL("INSERT INTO t_persona (correo, nombre, password, edad, altura, peso, genero, actividad) VALUES ('"+ correoAdmin +
                "', '" + nombre + "', '" + password + "'," + edad + " ," + altura + "," + peso + " , '" + genero + "', '" + actividad +"')");

        db.close();
    }




}