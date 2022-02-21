package com.asier.aranda.strong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.asier.aranda.strong.fragment.Page1;

import com.asier.aranda.strong.BDPersona.DataPersona;


public class DespuesDeRegistro extends AppCompatActivity {
    EditText edad, peso, altura;
    RadioGroup actividad, genero;
    Button accionTerminaRegistro;

    RadioButton generoHombre, generoMujer, actividadPrincipiante, actividadActivo;
    String datoActividad, datoGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despues_registro);

         DataPersona bbdd = new DataPersona(DespuesDeRegistro.this);


        // VARIABLES
        edad = findViewById(R.id.edadDespRegistro);
        peso = findViewById(R.id.pesoDesRegistro);
        altura = findViewById(R.id.alturaRegistro);
        accionTerminaRegistro = findViewById(R.id.terminaRegistro);
        actividad = findViewById(R.id.radioActividad);
        genero = findViewById(R.id.radioGenero);


        actividad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                actividadActivo = findViewById(R.id.activo);
                actividadPrincipiante = findViewById(R.id.principiante);
                /*
                if(checkedId == actividadActivo){
                    datoActividad ==

                }else if (checkedId == actividadPrincipiante){

                }*/
            }
        });



        accionTerminaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float datoPeso = Float.parseFloat(peso.getText().toString());
                int datoEdad = Integer.parseInt(edad.getText().toString());
                Float datoAltura = Float.parseFloat(altura.getText().toString());

                Intent intent=new Intent(DespuesDeRegistro.this, MainBN.class);
                startActivity(intent);

                //persona = new GestionPersona(datoPeso, datoEdad, datoAltura);

            }
        });

    public void volverAtras(View view){
        Intent intent=new Intent(DespuesDeRegistro.this, Registro.class);
        startActivity(intent);
    }


}
