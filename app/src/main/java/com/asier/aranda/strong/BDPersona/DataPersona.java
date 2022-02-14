package com.asier.aranda.strong.BDPersona;

import android.content.Context;
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
            db.execSQL("INSERT INTO t_persona (id, correo, nombre, password ) VALUES ('"+ p.getEmail() +
                    "', '" + p.getUsername() + "', '" + p.getPassword());
            db.close();
        }
    }

}
