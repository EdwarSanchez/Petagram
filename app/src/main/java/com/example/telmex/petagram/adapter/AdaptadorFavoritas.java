package com.example.telmex.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telmex.petagram.R;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 22/04/2017.
 */

public class AdaptadorFavoritas extends RecyclerView.Adapter<AdaptadorFavoritas.FavoritasViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public AdaptadorFavoritas(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @Override
    public FavoritasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_favoritos,parent,false);

        return new FavoritasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoritasViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.ivMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvCantidad.setText(""+mascota.getCantidadLikes());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class FavoritasViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivMascota;
        private TextView tvNombre;
        private TextView tvCantidad;
        private ImageView ivHueso;

        public FavoritasViewHolder(View itemView) {
            super(itemView);
            ivMascota = (ImageView)itemView.findViewById(R.id.ivMascota);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvCantidad = (TextView)itemView.findViewById(R.id.tvCantidad);
            ivHueso = (ImageView)itemView.findViewById(R.id.ivHueso);
        }
    }
}
