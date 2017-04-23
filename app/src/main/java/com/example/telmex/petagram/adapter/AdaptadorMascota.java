package com.example.telmex.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telmex.petagram.R;
import com.example.telmex.petagram.db.ConstructorMascotas;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 10/04/2017.
 */

public class AdaptadorMascota extends RecyclerView.Adapter<AdaptadorMascota.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public AdaptadorMascota(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.ivMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvCantidad.setText(""+mascota.getCantidadLikes());



        holder.ibLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                holder.tvCantidad.setText(""+constructorMascotas.obtenerLikesMascota(mascota));
                if(constructorMascotas.obtenerNumeroRegistros() < 5){
                    constructorMascotas.insertarFavorita(mascota);
                }

                else
                {
                    constructorMascotas.eliminarRegistro(constructorMascotas.obtenerPrimerRegistro());
                    constructorMascotas.insertarFavorita(mascota);
                }

                /*int resultado = sumaLikes(mascota.getCantidadLikes());
                holder.tvCantidad.setText(""+resultado);
                mascota.setCantidadLikes(resultado);*/
            }
        });




    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivMascota;
        private ImageButton ibLikes;
        private ImageView ivCantidad;
        private TextView tvNombre;
        private TextView tvCantidad;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            ivMascota  = (ImageView)itemView.findViewById(R.id.ivMascota);
            ibLikes    = (ImageButton)itemView.findViewById(R.id.ibHueso);
            tvNombre   = (TextView)itemView.findViewById(R.id.tvNombre);
            tvCantidad = (TextView)itemView.findViewById(R.id.tvCantidad);

        }
    }

    /*public int sumaLikes(int likes)
    {
        int resultado = 0;
        resultado = likes + 1;
        return resultado;
    }*/
}
