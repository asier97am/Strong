package com.asier.aranda.strong.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.asier.aranda.strong.DespuesDeRegistro;
import com.asier.aranda.strong.MainBN;
import com.asier.aranda.strong.Persona;
import com.asier.aranda.strong.R;
import com.asier.aranda.strong.bbddUser.DataPersona;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Page3 extends Fragment {

    private ImageView info;
    private Button btGuardar;

    Persona persona;
    EditText nombrePersona, edadPersona, pesoPersona, alturaPersona, emailPersona;
    RadioGroup actividadPersona, generoPersona;
    RadioButton hombreP, mujerP, activoPerfil, principiantePerfil;
    Button btnGuardar;
    String datoActividad = "", datoGenero = "";


    public Page3(Persona persona){
        this.persona = persona;
    }
    public Page3() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3_profile2, container, false);
        ImageView button = (ImageView) view.findViewById(R.id.info);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogButtonClicked(Page3.this);
            }
        });

        nombrePersona = view.findViewById(R.id.etNombre);
        edadPersona = view.findViewById(R.id.etEdad);
        alturaPersona = view.findViewById(R.id.etAltura);
        emailPersona = view.findViewById(R.id.etMail);
        pesoPersona = view.findViewById(R.id.etPeso);
        actividadPersona = view.findViewById(R.id.actividadPerfil);
        generoPersona = view.findViewById(R.id.generoPerfil);
        hombreP = view.findViewById(R.id.hombrePerfil);
        mujerP = view.findViewById(R.id.mujerPerfil);
        activoPerfil = view.findViewById(R.id.activoPerfil);
        principiantePerfil = view.findViewById(R.id.principiantePerfil);
        DataPersona bbdd = new DataPersona(getContext());


/*
        nombrePersona.setText(persona.getUsername());
        edadPersona.setText(persona.getEdad() + "");
        alturaPersona.setText(persona.getAltura().toString());
        emailPersona.setText(persona.getEmail());
        pesoPersona.setText(persona.getPeso().toString());

        if(persona.getGenero().equals("Hombre")){
            hombreP.setChecked(true);
        }else{
            mujerP.setChecked(true);
        }

        if(persona.getActividad().equals("Principiante")){
            principiantePerfil.setChecked(true);
        }else{
            activoPerfil.setChecked(true);
        }
*/

        mostrarDatosPersona();

        actividadPersona.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == activoPerfil.getId()){
                    datoActividad = "Activo";
                }else if(checkedId == principiantePerfil.getId()){
                    datoActividad = "Principiante";
                }
            }
        });

        generoPersona.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == hombreP.getId()){
                    datoGenero = "Hombre";
                }else if(checkedId == mujerP.getId()){
                    datoGenero = "Mujer";
                }
            }
        });


        btnGuardar = view.findViewById(R.id.btGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int e = Integer.parseInt(edadPersona.getText().toString());


                persona.setUsername(nombrePersona.getText().toString());
                persona.setEdad(e);
                Float a = Float.parseFloat(alturaPersona.getText().toString());
                persona.setAltura(a);

                a = Float.parseFloat(pesoPersona.getText().toString());
                persona.setPeso(a);
                persona.setEmail(emailPersona.getText().toString());
                persona.setGenero(datoGenero);
                persona.setActividad(datoActividad);

                bbdd.cambioDatosPersona(persona);

                Toast.makeText(getContext(), "Se ha modificado el perfil.", Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }


    public void showAlertDialogButtonClicked(Page3 Page3){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext(),R.style.Theme_Alert);
        builder.setTitle("Información");//TITULO
        builder.setMessage("Aquí podrás cambiar tus datos por si te equivocaste");//MENSAJITO
        builder.setIcon(R.drawable.information);//ICONO
        builder.setCancelable(false);
        builder.setNeutralButton("Skip", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void mostrarDatosPersona(){
        nombrePersona.setText(persona.getUsername());
        edadPersona.setText(persona.getEdad() + "");
        alturaPersona.setText(persona.getAltura().toString());
        emailPersona.setText(persona.getEmail());
        pesoPersona.setText(persona.getPeso().toString());

        if(persona.getGenero().equals("Hombre")){
            datoGenero = "Hombre";
            hombreP.setChecked(true);
        }else{
            datoGenero = "Mujer";
            mujerP.setChecked(true);
        }

        if(persona.getActividad().equals("Principiante")){
            datoActividad = "Principiante";
            principiantePerfil.setChecked(true);
        }else{
            datoActividad = "Activo";
            activoPerfil.setChecked(true);
        }
    }
}