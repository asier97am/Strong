package com.asier.aranda.strong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SistemaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);


    }

    public void passOlvidada(View v){

        Intent intent = new Intent(this, SistemaRecuperacionContraseña.class);
        startActivity(intent);

    }

}
