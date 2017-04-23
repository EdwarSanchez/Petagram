package com.example.telmex.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telmex.petagram.R;
import com.example.telmex.petagram.adapter.AdaptadorMascota;
import com.example.telmex.petagram.poyo.Mascota;
import com.example.telmex.petagram.presentador.FragmentMascotasPresenter;
import com.example.telmex.petagram.presentador.IFragmentMascotasPresenter;

import java.util.ArrayList;

/**
 * Created by telmex on 20/04/2017.
 */

public class FragmentMascotas extends Fragment implements IFragmentMascotas {

    RecyclerView recyclerViewMascota;
    ArrayList<Mascota> mascotas;
    IFragmentMascotasPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mascotas_fragment,container,false);

        recyclerViewMascota = (RecyclerView)v.findViewById(R.id.rvPetagram);

        presenter = new FragmentMascotasPresenter(this,getContext());

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void generarLinerLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewMascota.setLayoutManager(linearLayoutManager);
    }

    @Override
    public AdaptadorMascota crearAdaptador(ArrayList<Mascota> mascotas) {
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas, getActivity()); //Se llena mi lista con todos los view que se crearon en el cardview
        return adaptador;
    }

    @Override
    public void iniciarAdaptadorRV(AdaptadorMascota adaptadorMascota) {
        recyclerViewMascota.setAdapter(adaptadorMascota);//La lista adaptador se adapta a nuestro recyclerview
    }
}
