package com.asier.aranda.strong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        AnimationABienvenida(true);

        // IMPLEMENTAR ANIMACION
        // animacion imagen1
        ImageView iv1= findViewById(R.id.iv1);
        android.view.animation.Animation blink1= AnimationUtils.loadAnimation(this, R.anim.blink1);
        iv1.startAnimation(blink1);

        // animacion imagen2
        ImageView iv2= findViewById(R.id.iv2);
        android.view.animation.Animation blink2= AnimationUtils.loadAnimation(this, R.anim.blink2);
        iv2.startAnimation(blink2);

        // animacion imagen3
        ImageView iv3= findViewById(R.id.iv3);
        android.view.animation.Animation blink3= AnimationUtils.loadAnimation(this, R.anim.blink3);
        iv3.startAnimation(blink3);

        // animacion imagen4
        ImageView iv4= findViewById(R.id.iv4);
        android.view.animation.Animation blink4= AnimationUtils.loadAnimation(this, R.anim.blink4);
        iv4.startAnimation(blink4);

        // animacion imagen5
        ImageView iv5= findViewById(R.id.iv5);
        android.view.animation.Animation blink5= AnimationUtils.loadAnimation(this, R.anim.blink5);
        iv5.startAnimation(blink5);

        // animacion imagen6
        ImageView iv6= findViewById(R.id.iv6);
        android.view.animation.Animation blink6= AnimationUtils.loadAnimation(this, R.anim.blink6);
        iv6.startAnimation(blink6);

        // animacion imagen7
        ImageView iv7= findViewById(R.id.iv7);
        android.view.animation.Animation blink7= AnimationUtils.loadAnimation(this, R.anim.blink7);
        iv7.startAnimation(blink7);

        // animacion imagen8
        ImageView iv8= findViewById(R.id.iv8);
        android.view.animation.Animation blink8= AnimationUtils.loadAnimation(this, R.anim.blink8);
        iv8.startAnimation(blink8);

        // animacion imagen9
        ImageView iv9= findViewById(R.id.iv9);
        android.view.animation.Animation blink9= AnimationUtils.loadAnimation(this, R.anim.blink9);
        iv9.startAnimation(blink9);

        //TOTAL TIEMPO ANIMACION --> 2997ms
    }

    private void AnimationABienvenida(boolean locationPermission) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                //aqui indicamos que vaya del Splash al login
                Intent intent = new Intent(Animation.this, Bienvenida.class);//SPLASH-->LOGIN
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//creamos bandera
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);//limpiamos para no poder volver
                startActivity(intent);//con esto vamos al siguiente activity indicando con la variable intent
            }
        }, 2500);//tarda 2500 milisegundos en pasar al siguiente activity
    }

}