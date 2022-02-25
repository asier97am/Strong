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
                "El músculo biceps está situado en la región posterior del brazo, está formado por la porción larga, vasto interno y externo.","Fondos de tríceps 4x6\nExtensión de codos sentado 5x15\nPatada horizontal en polea 4x12\nPress francés 4x8",
                R.drawable.triceps));
        ejercicioLista.add(new EjerciciosHome("Gemelo",
                "El gemelo es un músculo situado en la región posterior de la pierna, y es el músculo más superficial de la pantorrilla.","Elevaciones de talones (sentado)4x10\nElevaciones de talones (de pie)5x15\nPrensa 4x30",
                R.drawable.gemelo));
        ejercicioLista.add(new EjerciciosHome("Cuadriceps",
                "El es músculo que soporta todo el peso del cuerpo humano y nos permite andar, sentarnos y correr. Se denomina cuádriceps debido a que tiene 4 cabezas musculares","Sentadilla 4x10 \nZancada inversa 5x12\nSprin en cuesta 4x5min",
                R.drawable.cuadriceps));
        ejercicioLista.add(new EjerciciosHome("Espalda",
                "Parte posterior del cuerpo humano, que va desde el cuello y hombro hasta la cintura. Su anchura va en función de la caja torácica y los hombros","Jalón al pecho 4x10\nRemo con barra 5x15\nDominada 4x6\nPull over con mancuerna 4x10",
                R.drawable.espalda));
        ejercicioLista.add(new EjerciciosHome("Pecho",
                "Músculo bástante grande que soporta gran cantidad de entrenamiento directo. El pecho se compone principalmente del pectoral mayor, menor y serrato anterior.","Press plano 4x12\nPress Inclinado 4x12\nPress declinado 3x10\nCruce de polea 4x15",
                R.drawable.pecho));
        ejercicioLista.add(new EjerciciosHome("Hombro",
                "El hombro situado encima del pecho, está compuesto por tres cabezas, la anterior, la media y la trasera.","Press militar 4x10\nElevación frontal 5x15\nElevación frontal 3x12",
                R.drawable.hombro));
    }

}