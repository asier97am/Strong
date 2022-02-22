package com.asier.aranda.strong.fragment;

import android.content.DialogInterface;
import android.content.Intent;
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

import com.asier.aranda.strong.MainBN;
import com.asier.aranda.strong.Persona;
import com.asier.aranda.strong.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Page3 extends Fragment {

    private ImageView info;

    Persona persona;
    EditText nombrePersona, edadPersona, pesoPersona, alturaPersona, emailPersona;
    RadioGroup actividadPersona, generoPersona;
    RadioButton hombreP, mujerP, activoPerfil, principiantePerfil;

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


        return view;
    }


    public void showAlertDialogButtonClicked(Page3 Page3){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        builder.setTitle("Información");//TITULO
        builder.setMessage("Aquí podrás cambiar tus datos por si te equivocaste");//MENSAJITO
        builder.setIcon(R.drawable.information);//ICONO
        builder.setCancelable(false);
        builder.setNeutralButton("skip", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }


}