package com.asier.aranda.strong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.asier.aranda.strong.bbddUser.DataPersona;

import java.io.Serializable;

public class Registro extends AppCompatActivity{
    EditText user, password, email, repPassword;
    DataPersona bbdd = new DataPersona(Registro.this);
    Button accionRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        user = findViewById(R.id.etNombreUsuario);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etContraseña);
        repPassword = findViewById(R.id.etRepiteContraseña);
        accionRegistrarse = findViewById(R.id.bt1_registro_registrarse);

        accionRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DespuesDeRegistro.class);
                Persona p = new Persona();

                String u = user.getText().toString();
                String c = email.getText().toString();
                String pas = password.getText().toString();
                boolean entrada = bbdd.busquedaDatosExistencia(u, pas);

                if(entrada){
                    Toast.makeText(getApplicationContext(), "Este usuario ya existe", Toast.LENGTH_SHORT).show();
                }else{

                    p.setUsername(u);
                    p.setEmail(c);
                    p.setPassword(pas);
                    intent.putExtra("persona", p);

                    startActivity(intent);

                }
            }
        });

    }

    public void bt1_registro_registrarse(View view) {

    }

    public void bt2_registro_volver_al_login(View view) {
        Intent intent=new Intent(Registro.this, SistemaLogin.class);
        startActivity(intent);
    }
}