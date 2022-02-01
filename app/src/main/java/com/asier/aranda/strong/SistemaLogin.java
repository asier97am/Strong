package com.asier.aranda.strong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SistemaLogin extends AppCompatActivity {
    EditText usuario, password;
    Button accionAccederAlHome, accionRegistrarse;

    Intent intent;

    //Usuario de prueba
    String usuarioAdmin = "admin", passwordAdmin = "admin";
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
                if(comprobacionUsuario(usuario.getText().toString(), password.getText().toString())){
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña no coinciden", Toast.LENGTH_LONG).show();
                }
            }
        });

        accionRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
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