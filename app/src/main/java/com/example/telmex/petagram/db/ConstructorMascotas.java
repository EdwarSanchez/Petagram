package com.example.telmex.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 20/04/2017.
 */

public class ConstructorMascotas {

    private Context context;
    private static final int LIKE = 1;

    public ConstructorMascotas(Context context)
    {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascota()
    {
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerMascota();

    }

    public ArrayList<Mascota> obtenerFavoritas(){
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerFavoritas();
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_IDMASCOTA, mascota.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_CANTIDAD, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public void insertarFavorita(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_FAVORITAS_IDMASCOTA, mascota.getId());
        db.insertarFavorita(contentValues);
    }

    public int obtenerNumeroRegistros(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerNumeroRegistros();
    }

    public void eliminarRegistro(int id){
        BaseDatos db = new BaseDatos(context);
        db.eliminarRegistro(id);
    }

    public int obtenerPrimerRegistro(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerPrimerRegistro();
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }




}
