package com.asier.aranda.strong.bbddUser;

import android.annotation.SuppressLint;
import android.content.Context;
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
                "apellido TEXT,"+
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

        String al = p.getAltura() + "";
        String pe = p.getPeso() + "";

        db.execSQL("UPDATE t_persona SET edad = " + p.getEdad() +", peso = '" + pe + "', altura = '"
                + al + "', genero = '" + p.getGenero() + "', actividad = '" + p.getActividad() + "', nombre = '" + p.getUsername() +"', email = '" + p.getEmail() + "'"
                + " where id = " + p.getIdentificador());

//        db.execSQL("UPDATE t_persona SET nombre = '" + p.getUsername() + "'"
//                + " where id = " + p.getIdentificador());
//
        db.close();

//        p.setEdad(p.getEdad());
//        p.setPeso(p.getPeso());
//        p.setAltura(p.getAltura());
//        p.setGenero(p.getGenero());
//        p.setActividad(p.getActividad());
//        p.setUsername(p.getUsername());
//        p.setEmail(p.getEmail());


    }

    @SuppressLint("Range")
    public Persona busquedaDatosPersona(String user, String pass){

        Persona p = new Persona();
        SQLiteDatabase db = getWritableDatabase();

        String dato = "";
        Cursor cursor = db.rawQuery("select id, correo, nombre, altura, peso, genero, actividad, edad from t_persona where nombre like '" + user + "' and password like '" + pass + "'", null);


        if(cursor != null){
            cursor.moveToFirst();
            dato = cursor.getString(cursor.getColumnIndex("id"));
            p.setIdentificador(dato);

            dato = cursor.getString(cursor.getColumnIndex("correo"));
            p.setEmail(dato);

//            dato = cursor.getString(cursor.getColumnIndex("apellido"));
//            p.setApellido(dato);

            dato = cursor.getString(cursor.getColumnIndex("nombre"));
            p.setUsername(dato);

//            dato = cursor.getString(cursor.getColumnIndex("password"));
//            p.setPassword(dato);

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
    public boolean busquedaDatosExistencia(String user, String pass){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select nombre, password from t_persona where nombre like '" + user + "' and password like '" + pass + "'", null);

        if(cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }

    }




}