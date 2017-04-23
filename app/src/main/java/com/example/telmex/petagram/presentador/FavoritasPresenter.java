package com.example.telmex.petagram.presentador;

import android.app.Activity;
import android.content.Context;

import com.example.telmex.petagram.IFavoritasActivity;
import com.example.telmex.petagram.db.ConstructorMascotas;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 22/04/2017.
 */

public class FavoritasPresenter implements IFavoritasPresenter {

    private IFavoritasActivity iFavoritasActivity;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public FavoritasPresenter(IFavoritasActivity iFavoritasActivity, Context context){
        this.iFavoritasActivity = iFavoritasActivity;
        this.context = context;
        obtenerContactosBaseDatos();

    }
    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerFavoritas();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iFavoritasActivity.iniciarAdaptadorRV(iFavoritasActivity.crearAdaptador(mascotas));
        iFavoritasActivity.generarLinerLayoutVertical();

    }
}
