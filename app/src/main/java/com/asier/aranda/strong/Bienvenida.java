package com.asier.aranda.strong;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Bienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

    }

    public void bt1_login_acceder(View view) {
    }

    public void bt2_login_entrar_como_invitado(View view) {
    }

    public void tv4_login_registro(View view) {
    }

    //borrar de aqui
    //AlertDialog
    public void myAlert(View view){
        AlertDialog.Builder MyAlert= new AlertDialog.Builder(this);
        MyAlert.setTitle("INFORMACIÓN");
        MyAlert.setMessage("Este cuadro de alerta sirve para informarte de el uso de esta pestaña");
        MyAlert.setPositiveButton("OKEY", null);
        AlertDialog dialog= MyAlert.create();
        dialog.show();
    }
}
