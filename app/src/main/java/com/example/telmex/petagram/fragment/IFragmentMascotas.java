package com.example.telmex.petagram.fragment;

import com.example.telmex.petagram.adapter.AdaptadorMascota;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 20/04/2017.
 */

public interface IFragmentMascotas {

    public void generarLinerLayoutVertical();

    public AdaptadorMascota crearAdaptador(ArrayList<Mascota> mascotas);

    public void iniciarAdaptadorRV(AdaptadorMascota adaptadorMascota);


}
