package com.example.telmex.petagram;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.telmex.petagram.adapter.AdaptadorFavoritas;
import com.example.telmex.petagram.adapter.AdaptadorMascota;
import com.example.telmex.petagram.poyo.Mascota;
import com.example.telmex.petagram.presentador.FavoritasPresenter;
import com.example.telmex.petagram.presentador.IFavoritasPresenter;

import java.util.ArrayList;

public class FavoritasActivity extends AppCompatActivity implements IFavoritasActivity{
    ArrayList<Mascota> mascotas;
    RecyclerView rvFavoritas;
    IFavoritasPresenter presenter;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        rvFavoritas = (RecyclerView)findViewById(R.id.rvFavoritos);

        presenter = new FavoritasPresenter(this,context);

    }

    @Override
    public void generarLinerLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavoritas.setLayoutManager(linearLayoutManager);

    }

    @Override
    public AdaptadorFavoritas crearAdaptador(ArrayList<Mascota> mascotas) {
        AdaptadorFavoritas adaptadorFavoritas = new AdaptadorFavoritas(mascotas,this);
        return adaptadorFavoritas;
    }

    @Override
    public void iniciarAdaptadorRV(AdaptadorFavoritas adaptadorFavoritas) {
        rvFavoritas.setAdapter(adaptadorFavoritas);
    }
}
