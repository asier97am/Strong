package com.asier.aranda.strong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;


import com.asier.aranda.strong.bbddUser.DataPersona;

public class Registro extends AppCompatActivity {
    EditText user, password, email, repPassword;
    Persona p = new Persona();
    DataPersona bbdd = new DataPersona(Registro.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        user = findViewById(R.id.etNombreUsuario);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etContraseña);
        repPassword = findViewById(R.id.etRepiteContraseña);


    }

    public void bt1_registro_registrarse(View view) {
        Intent intent = new Intent(Registro.this, DespuesDeRegistro.class);

        p.setUsername(user.getText().toString());
        p.setEmail(email.getText().toString());
        p.setPassword(password.getText().toString());

        bbdd.agregarUsuario(p);



        startActivity(intent);
    }

    public void bt2_registro_volver_al_login(View view) {
        Intent intent=new Intent(Registro.this, SistemaLogin.class);
        startActivity(intent);
    }
}