package com.asier.aranda.strong.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asier.aranda.strong.EjerciciosHome;
import com.asier.aranda.strong.R;
import com.asier.aranda.strong.RecyclerViewAdaptador;

import java.util.ArrayList;
import java.util.List;


public class Page1 extends Fragment {

    //RECYCLER

    private RecyclerView recyclerViewEjercicio;
    private RecyclerViewAdaptador adaptadorEjercicio;

    //
    ArrayList<EjerciciosHome> ejercicioLista;

    public Page1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment1_home, container, false);
        ejercicioLista= new ArrayList<>();
        recyclerViewEjercicio=vista.findViewById(R.id.RecyclerId);
        recyclerViewEjercicio.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();

        RecyclerViewAdaptador adaptador= new RecyclerViewAdaptador(ejercicioLista,getContext());
        recyclerViewEjercicio.setAdapter(adaptador);

        return vista;

    }

    private void llenarLista() {
        ejercicioLista.add(new EjerciciosHome("Biceps",
                "El  bíceps es un musculo que se encuentra en la parte frontal del brazo. Su funcion principal está en el codo, donde flexiona el antebrazo y supina el antebrazo","Curl un solo brazo 4x10\nDominadas supinas 5x8\nCurl con zarra Z 4x10\nCurl con polea baja 4x12",
                R.drawable.biceps1));
        ejercicioLista.add(new EjerciciosHome("Triceps",
                "El músculo biceps está situado en la región posterior del brazo, está formado por la porción larga, vasto interno y externo.","4x10 \n5x15 \n",
                R.drawable.triceps));
        ejercicioLista.add(new EjerciciosHome("Gemelo",
                "El gemelo es un músculo situado en la región posterior de la pierna, y es el músculo más superficial de la pantorrilla.","4x10 \n5x15 \n",
                R.drawable.gemelo));
        ejercicioLista.add(new EjerciciosHome("Cuadriceps",
                "El es músculo que soporta todo el peso del cuerpo humano y nos permite andar, sentarnos y correr. Se denomina cuádriceps debido a que tiene 4 cabezas musculares","4x10 \n5x15 \n",
                R.drawable.cuadriceps));
        ejercicioLista.add(new EjerciciosHome("Espalda",
                "Parte posterior del cuerpo humano, que va desde el cuello y hombro hasta la cintura. Su anchura va en función de la caja torácica y los hombros","4x10 \n5x15 \n",
                R.drawable.espalda));
        ejercicioLista.add(new EjerciciosHome("Pecho",
                "El músculo bíceps braquial se encuentra en el brazo, cubriendo los músculos braquial anterior y 1 2 3 4 5.","4x10 \n5x15 \n",
                R.drawable.pecho));
        ejercicioLista.add(new EjerciciosHome("Hombro",
                "El músculo bíceps braquial se encuentra en el brazo, cubriendo los músculos braquial anterior y 1 2 3 4 5.","4x10 \n5x15 \n",
                R.drawable.hombro));
    }

}