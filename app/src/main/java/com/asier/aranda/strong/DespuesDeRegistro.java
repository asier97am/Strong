package com.asier.aranda.strong;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.asier.aranda.strong.bbddUser.DataPersona;
import com.asier.aranda.strong.fragment.Page1;

import java.io.Serializable;


public class DespuesDeRegistro extends AppCompatActivity{
    EditText edad, peso, altura;
    RadioGroup actividad, genero;
    Button accionTerminaRegistro;

    DataPersona bbdd = new DataPersona(DespuesDeRegistro.this);
    Persona p = new Persona();

    String datoActividad, datoGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despues_registro);

        // VARIABLES
        edad = findViewById(R.id.edadDespRegistro);
        peso = findViewById(R.id.pesoDesRegistro);
        altura = findViewById(R.id.alturaRegistro);
        actividad = findViewById(R.id.radioActividad);
        genero = findViewById(R.id.radioGenero);

        accionTerminaRegistro = findViewById(R.id.terminaRegistro);

        p = (Persona) this.getIntent().getParcelableExtra("persona");

        actividad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.principiante){
                    datoActividad = "Principiante";
                }else if(checkedId == R.id.activo){
                    datoActividad = "Activo";
                }else{
                    Toast.makeText(getApplicationContext(), "Seleccionar un tipo de actividad", Toast.LENGTH_LONG).show();
                }
            }
        });

        genero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.generoHombre){
                    datoGenero = "Hombre";
                }else if(checkedId == R.id.generoMujer){
                    datoGenero = "Mujer";
                }else{
                    Toast.makeText(getApplicationContext(), "Seleccionar una", Toast.LENGTH_LONG).show();
                }

            }
        });


        accionTerminaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DespuesDeRegistro.this, MainBN.class);

                int e = Integer.parseInt(edad.getText().toString());
                p.setEdad(e);
                Float pe = Float.parseFloat(altura.getText().toString());
                p.setAltura(pe);
                pe = Float.parseFloat(peso.getText().toString());
                p.setPeso(pe);
                p.setGenero(datoGenero);
                p.setActividad(datoActividad);

                bbdd.agregarUsuario(p);
                Toast.makeText(getApplicationContext(), p.toString(), Toast.LENGTH_LONG).show();
                startActivity(intent);


            }
        });

    }

    public void volverAtras(View view){
        Intent intent=new Intent(DespuesDeRegistro.this, Registro.class);
        startActivity(intent);
    }


}
