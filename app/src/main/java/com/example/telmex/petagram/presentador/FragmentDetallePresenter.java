package com.example.telmex.petagram.presentador;

import android.content.Context;

import com.example.telmex.petagram.db.ConstructorMascotas;
import com.example.telmex.petagram.fragment.FragmentDetalle;
import com.example.telmex.petagram.fragment.IFragmentDetalle;
import com.example.telmex.petagram.fragment.IFragmentMascotas;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 21/04/2017.
 */

public class FragmentDetallePresenter implements IFragmentDetallePresenter {

    private IFragmentDetalle iFragmentMascotasPresenter;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FragmentDetallePresenter(IFragmentDetalle iFragmentMascotas, Context context)
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
