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
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.asier.aranda.strong.MainBN;
import com.asier.aranda.strong.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Page3 extends Fragment {

    private ImageView info;
    private Button btGuardar;

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
        return view;
    }


    public void showAlertDialogButtonClicked(Page3 Page3){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext(),R.style.Theme_Alert);
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

    public void btGuardar (View view){
        Toast.makeText(getContext(), "SAVE", Toast.LENGTH_SHORT).show();

    }


}