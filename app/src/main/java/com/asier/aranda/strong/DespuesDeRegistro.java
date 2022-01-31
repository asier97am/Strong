package com.asier.aranda.strong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


public class DespuesDeRegistro extends AppCompatActivity {
    EditText edad, peso, altura;
    RadioGroup actividad, genero;
    Button accionTerminaRegistro;
    GestionPersona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despues_registro);

        // VARIABLES
        edad = findViewById(R.id.edadDespRegistro);
        peso = findViewById(R.id.pesoDesRegistro);
        altura = findViewById(R.id.alturaRegistro);
        accionTerminaRegistro = findViewById(R.id.terminaRegistro);
        actividad = findViewById(R.id.radioActividad);
        genero = findViewById(R.id.radioGenero);


        accionTerminaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float datoPeso = Float.parseFloat(peso.getText().toString());
                int datoEdad = Integer.parseInt(edad.getText().toString());
                Float datoAltura = Float.parseFloat(altura.getText().toString());


                persona = new GestionPersona(datoPeso, datoEdad, datoAltura);

            }
        });

    }


}
