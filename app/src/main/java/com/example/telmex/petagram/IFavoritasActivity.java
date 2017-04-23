package com.example.telmex.petagram;

import com.example.telmex.petagram.adapter.AdaptadorFavoritas;
import com.example.telmex.petagram.adapter.AdaptadorMascota;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 22/04/2017.
 */

public interface IFavoritasActivity {
    public void generarLinerLayoutVertical();

    public AdaptadorFavoritas crearAdaptador(ArrayList<Mascota> mascotas);

    public void iniciarAdaptadorRV(AdaptadorFavoritas adaptadorFavoritas);
}
