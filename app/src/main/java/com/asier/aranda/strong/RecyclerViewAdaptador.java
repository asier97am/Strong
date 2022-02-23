package com.asier.aranda.strong;

import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ejercicio, descripcion;
        private ImageView fotoEjercicio;

        public ViewHolder(View itemView) {
            super(itemView);
            ejercicio = itemView.findViewById(R.id.tvEjercicio);
            descripcion = itemView.findViewById(R.id.tvDescripcion);
            fotoEjercicio = itemView.findViewById(R.id.fotoEjercicio);
        }
    }

    public List<EjerciciosHome> ejercicioLista;

    public RecyclerViewAdaptador(List<EjerciciosHome> ejercicioLista) {
        this.ejercicioLista = ejercicioLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ejercicio, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ejercicio.setText(ejercicioLista.get(position).getEjercicio());
        holder.descripcion.setText(ejercicioLista.get(position).getDescripcion());
        holder.fotoEjercicio.setImageResource(ejercicioLista.get(position).getFotoEjercicio());
    }

    @Override
    public int getItemCount(){
        return ejercicioLista.size();
    }


}
