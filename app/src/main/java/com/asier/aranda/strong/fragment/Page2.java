package com.asier.aranda.strong.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.asier.aranda.strong.MainBN;
import com.asier.aranda.strong.Persona;
import com.asier.aranda.strong.R;

import org.w3c.dom.Text;

public class Page2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Nuevo por parte de la pagina.
    private TextView nombreTitulo, tvPesoIdeal, tvPasosDiarios, tvKcalDiarios;

    Persona persona = new Persona();

    public Page2(Persona persona) {
        // Required empty public constructor
        this.persona = persona;
    }

    public Page2() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ImageView mback =findViewById(R.id.backView);
//        Glide.with(this)
//                .load(R.drawable.fondo3)
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.negroApp)))
//                .centerCrop()
//                .into(mback);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ImageView mback= new ImageView(.findViewById(R.id.backView));

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment2_estadisticas, container, false);

        nombreTitulo = view.findViewById(R.id.tvNombreUsuario);
        tvPesoIdeal = view.findViewById(R.id.tvVisualizaPeso);
        tvPasosDiarios = view.findViewById(R.id.tvVisualizaPasos);
        tvKcalDiarios = view.findViewById(R.id.tvVisualizaKcal);

        tvPesoIdeal.setText(persona.pesoIdeal() + "");
        tvPasosDiarios.setText(persona.pasosDiariosRecomendados() + "");
        tvKcalDiarios.setText(persona.getCaloriasAQuemar());
        nombreTitulo.setText(persona.getUsername());


        return view;
    }


}

