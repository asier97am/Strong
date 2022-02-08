package com.asier.aranda.strong;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        // IMPLEMENTAR ANIMACION
        TextView tv1= (TextView) findViewById(R.id.tv1);
        android.view.animation.Animation blink= AnimationUtils.loadAnimation(this, R.anim.blink);
        tv1.startAnimation(blink);


        ImageView iv1= (ImageView) findViewById(R.id.iv1);
        android.view.animation.Animation blink1= AnimationUtils.loadAnimation(this, R.anim.blink);
        iv1.startAnimation(blink1);
    }
}