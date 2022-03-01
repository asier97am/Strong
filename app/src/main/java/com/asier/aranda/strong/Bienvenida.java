package com.asier.aranda.strong;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.asier.aranda.strong.fragment.Page1;

public class Bienvenida extends AppCompatActivity {

    private Button bt1_bienvenida_acceder, bt2_bienvenida_entrar_como_invitado;
    private TextView tv4_bienvenida_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        bt1_bienvenida_acceder = findViewById(R.id.bt1_bienvenida_acceder);
        bt2_bienvenida_entrar_como_invitado = findViewById(R.id.bt2_bienvenida_entrar_como_invitado);
        tv4_bienvenida_registro = findViewById(R.id.tv4_bienvenida_registro);

    }

    public void bt1_login_acceder(View view) {
        Intent intent = new Intent(Bienvenida.this, SistemaLogin.class);
        startActivity(intent);
    }

    public void bt2_login_entrar_como_invitado(View view) {
        Intent intent = new Intent(Bienvenida.this, MainBN.class);
        startActivity(intent);
    }

    public void tv4_login_registro(View view) {
        Intent intent = new Intent(Bienvenida.this, Registro.class);
        startActivity(intent);
    }

//    //borrar de aqui
//    //AlertDialog
//    public void myAlert(View view){
//        AlertDialog.Builder MyAlert= new AlertDialog.Builder(this);
//        MyAlert.setTitle("INFORMACIÓN");
//        MyAlert.setMessage("Este cuadro de alerta sirve para informarte de el uso de esta pestaña");
//        MyAlert.setPositiveButton("OKEY", null);
//        AlertDialog dialog= MyAlert.create();
//        dialog.show();
//    }
}
