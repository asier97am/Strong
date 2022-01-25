package com.asier.aranda.strong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Bienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

    }
}

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //glide for loading girls
        ImageView mFondo= findViewById(R.id.fondo);

        Glide.with(this)
                .load(R.drawable.brazaco)
                .transition(DrawableTransitionOptions.withCrossFade(400))
                //.load("https://images.unsplash.com/photo-1459802071246-377c0346da93?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=409&q=80")
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia)))
                .into(mFondo);
    }*/