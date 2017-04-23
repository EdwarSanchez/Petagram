package com.example.telmex.petagram.presentador;

import android.content.Context;

import com.example.telmex.petagram.db.ConstructorMascotas;
import com.example.telmex.petagram.fragment.IFragmentMascotas;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 20/04/2017.
 */

public class FragmentMascotasPresenter implements IFragmentMascotasPresenter {

    private IFragmentMascotas iFragmentMascotasPresenter;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FragmentMascotasPresenter(IFragmentMascotas iFragmentMascotas, Context context)
    {
        this.iFragmentMascotasPresenter = iFragmentMascotas;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascota();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iFragmentMascotasPresenter.iniciarAdaptadorRV(iFragmentMascotasPresenter.crearAdaptador(mascotas));
        iFragmentMascotasPresenter.generarLinerLayoutVertical();
    }
}
