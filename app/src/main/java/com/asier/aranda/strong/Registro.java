package com.asier.aranda.strong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.asier.aranda.strong.fragment.Page1;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void bt1_registro_registrarse(View view) {
        Intent intent=new Intent(Registro.this, DespuesDeRegistro.class);
        startActivity(intent);
    }

    public void bt2_registro_volver_al_login(View view) {
        Intent intent=new Intent(Registro.this, SistemaLogin.class);
        startActivity(intent);
    }
}