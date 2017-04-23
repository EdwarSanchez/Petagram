package com.example.telmex.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telmex.petagram.R;
import com.example.telmex.petagram.db.ConstructorMascotas;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 21/04/2017.
 */

public class AdaptadorDetalle extends RecyclerView.Adapter<AdaptadorDetalle.DetalleViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public AdaptadorDetalle(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    public AdaptadorDetalle(){}



    @Override
    public DetalleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_detalle,parent,false);
        return new DetalleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetalleViewHolder holder, int position) {
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
        Mascota mascota = mascotas.get(position);
        holder.ivMascota.setImageResource(mascota.getFoto());
        holder.tvCantidad.setText(""+constructorMascotas.obtenerLikesMascota(mascota));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class DetalleViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivMascota;
        private ImageView ivHueso;
        public TextView tvCantidad;

        public DetalleViewHolder(View itemView) {
            super(itemView);
            ivMascota = (ImageView) itemView.findViewById(R.id.ivMascota);
            ivHueso = (ImageView) itemView.findViewById(R.id.ivHueso);
            tvCantidad = (TextView)itemView.findViewById(R.id.tvCantidad);
        }
    }
}
