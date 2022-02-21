package com.asier.aranda.strong.bbddUser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                "apellido TEXT,"+
                "nombre TEXT NOT NULL," +
                "password TEXT NOT NULL," +
                "altura TEXT,"+
                "peso TEXT," +
                "genero TEXT, " +
                "actividad TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void agregarUsuario(Persona p){
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            db.execSQL("INSERT INTO t_persona (correo, nombre, password ) VALUES ('"+ p.getEmail() +
                    "', '" + p.getUsername() + "', '" + p.getPassword() + "')");
            db.close();
        }
    }

    public Persona acabarPerfil(Persona p){
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("UPDATE t_persona SET edad = " + p.getEdad() +", peso = " + p.getPeso() + ", altura = "
                + p.getAltura() + ", genero = '" + p.getGenero() + "', actividad = '" + p.getActividad()
                + "' where id = " + p.getIdentificador());

        db.close();

        return p;
    }

    @SuppressLint("Range")
    public Persona busquedaDatosPersona(String id){

        Persona p = new Persona();
        SQLiteDatabase db = getWritableDatabase();

        String dato = "";
        Cursor cursor = db.rawQuery("select * from t_almacen where id = " + id, null);

        cursor.moveToFirst();

        dato = cursor.getString(cursor.getColumnIndex("id"));
        p.setIdentificador(dato);

        dato = cursor.getString(cursor.getColumnIndex("correo"));
        p.setEmail(dato);

        dato = cursor.getString(cursor.getColumnIndex("apellido"));
        p.setApellido(dato);

        dato = cursor.getString(cursor.getColumnIndex("nombre"));
        p.setUsername(dato);

        dato = cursor.getString(cursor.getColumnIndex("password"));
        p.setPassword(dato);

        dato = cursor.getString(cursor.getColumnIndex("altura"));
        p.setAltura(Float.parseFloat(dato));

        dato = cursor.getString(cursor.getColumnIndex("peso"));
        p.setPeso(Float.parseFloat(dato));

        dato = cursor.getString(cursor.getColumnIndex("genero"));
        p.setGenero(dato);

        dato = cursor.getString(cursor.getColumnIndex("actividad"));
        p.setActividad(dato);

        cursor.close();

        return p;

    }


}