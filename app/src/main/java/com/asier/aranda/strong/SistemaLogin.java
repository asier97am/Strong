package com.asier.aranda.strong;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.asier.aranda.strong.bbddUser.DataPersona;
import com.asier.aranda.strong.fragment.Page1;

public class SistemaLogin extends AppCompatActivity {
    EditText usuario, password;
    Button accionAccederAlHome, accionRegistrarse;
    DataPersona bbdd = new DataPersona(SistemaLogin.this);
    Intent intent;

    //Usuario de prueba
    String usuarioAdmin = "admin@gmail.com", passwordAdmin = "admin";
    // -------

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        //Variables
        usuario = findViewById(R.id.emailSesion);
        password = findViewById(R.id.passwordSesion);
        accionAccederAlHome = findViewById(R.id.accederAlHome);
        accionRegistrarse = findViewById(R.id.accionRegistrarse);

        accionAccederAlHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = new Persona();
                String user = usuario.getText().toString();
                String pass = password.getText().toString();

                if(bbdd.busquedaDatosPersona(user, pass) != null){
                    intent = new Intent(SistemaLogin.this, MainBN.class);
                    p = bbdd.busquedaDatosPersona(user, pass);
                    intent.putExtra("persona", p);

                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña no coinciden", Toast.LENGTH_LONG).show();
                }
            }
        });


        accionRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SistemaLogin.this, Registro.class);
                startActivity(intent);
            }
        });
    }

    public void passOlvidada(View v){
        intent = new Intent(this, SistemaRecuperacionContraseña.class);
        startActivity(intent);
    }

    public boolean comprobacionUsuario(String user, String pass){
        boolean entrada = false;

        if(user.equals(usuarioAdmin) && pass.equals(passwordAdmin)){
            entrada = true;
        }
        return entrada;

    }

}
