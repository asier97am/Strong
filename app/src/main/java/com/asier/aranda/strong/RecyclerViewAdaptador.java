package com.asier.aranda.strong;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ejercicio, descripcion,descripcion2;
        private ImageView fotoEjercicio;
        private CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            ejercicio = itemView.findViewById(R.id.tvEjercicio);
            descripcion = itemView.findViewById(R.id.tvDescripcion);
            fotoEjercicio = itemView.findViewById(R.id.fotoEjercicio);
            card_view = itemView.findViewById(R.id.card_view);
        }
    }

    public ArrayList<EjerciciosHome> ejercicioLista= new ArrayList<>();

    public RecyclerViewAdaptador(ArrayList<EjerciciosHome> ejercicioLista, Context context) {
        this.ejercicioLista = ejercicioLista;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ejercicio, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

//    @Override
////    public void onBindViewHolder(ViewHolder holder, int position) {
////        holder.ejercicio.setText(ejercicioLista.get(position).getEjercicio());
////        holder.descripcion.setText(ejercicioLista.get(position).getDescripcion());
////        holder.fotoEjercicio.setImageResource(ejercicioLista.get(position).getFotoEjercicio());
////    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {


        EjerciciosHome ejercicioLista1=ejercicioLista.get(position);
        viewHolder.ejercicio.setText(ejercicioLista.get(position).getEjercicio());
        viewHolder.descripcion.setText(ejercicioLista.get(position).getDescripcion());
       // viewHolder.descripcion2.setText(ejercicioLista.get(position).getDescripcion2());
        viewHolder.fotoEjercicio.setImageResource(ejercicioLista.get(position).getFotoEjercicio());


        viewHolder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                View view=LayoutInflater.from(builder.getContext()).inflate(R.layout.ejercicio_biceps1,null);
                ImageView dimg=(ImageView)view.findViewById(R.id.foto);

                Picasso.with(context).load(ejercicioLista1.getFotoEjercicio()).into(dimg);
                TextView tvname=(TextView)view.findViewById(R.id.tituloEjercicio);
                tvname.setText(ejercicioLista1.getEjercicio());
                TextView moviename=(TextView)view.findViewById(R.id.decripcionEjercicio2);
               // TextView moviename2=(TextView)view.findViewById(R.id.moviename2);
                moviename.setText(ejercicioLista1.getDescripcion2());
               // moviename2.setText(ejercicioLista1.getDescripcion2());
                builder.setView(view);

                builder.setNegativeButton("back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }

        });
    }



    @Override
    public int getItemCount(){
        return ejercicioLista.size();
    }


}
