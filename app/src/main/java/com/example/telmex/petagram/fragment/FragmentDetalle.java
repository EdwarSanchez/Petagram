package com.example.telmex.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telmex.petagram.R;
import com.example.telmex.petagram.adapter.AdaptadorDetalle;
import com.example.telmex.petagram.adapter.AdaptadorMascota;
import com.example.telmex.petagram.poyo.Mascota;
import com.example.telmex.petagram.presentador.FragmentDetallePresenter;
import com.example.telmex.petagram.presentador.FragmentMascotasPresenter;
import com.example.telmex.petagram.presentador.IFragmentDetallePresenter;
import com.example.telmex.petagram.presentador.IFragmentMascotasPresenter;

import java.util.ArrayList;

/**
 * Created by telmex on 20/04/2017.
 */

public class FragmentDetalle extends Fragment implements  IFragmentDetalle {

    RecyclerView recyclerViewMascota;
    ArrayList<Mascota> mascotas;
    IFragmentDetallePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalle_fragment,container,false);
        recyclerViewMascota = (RecyclerView)view.findViewById(R.id.rvDetalle);

        presenter = new FragmentDetallePresenter(this,getContext());

        return view;
    }

    @Override
    public void generarLinerLayoutVertical() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        recyclerViewMascota.setLayoutManager(glm);
    }

    @Override
    public AdaptadorDetalle crearAdaptador(ArrayList<Mascota> mascotas) {
        AdaptadorDetalle adaptador = new AdaptadorDetalle(mascotas, getActivity()); //Se llena mi lista con todos los view que se crearon en el cardview
        return adaptador;
    }

    @Override
    public void iniciarAdaptadorRV(AdaptadorDetalle adaptadorMascota) {
        recyclerViewMascota.setAdapter(adaptadorMascota);//La lista adaptador se adapta a nuestro recyclerview

    }
}
