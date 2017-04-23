package com.example.telmex.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.telmex.petagram.R;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by telmex on 20/04/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryTablaPetagram = "CREATE TABLE "+ConstantesBD.TABLE_NAME_MASCOTA+ "( " +
                ConstantesBD.TABLE_MASCOTA_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_MASCOTA_NOMBRE +" TEXT, "+
                ConstantesBD.TABLE_MASCOTA_FOTO +" INTEGER "+
                ")";

        String queryTablaLikes = "CREATE TABLE "+ConstantesBD.TABLE_NAME_LIKES+ "( " +
                ConstantesBD.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_LIKES_IDMASCOTA + " INTEGER, " +
                ConstantesBD.TABLE_LIKES_CANTIDAD + " INTEGER, " +
                " FOREIGN KEY (" + ConstantesBD.TABLE_LIKES_IDMASCOTA + " ) " +
                " REFERENCES " + ConstantesBD.TABLE_NAME_MASCOTA + "( " + ConstantesBD.TABLE_MASCOTA_ID +" ) " +
                " ) ";

        String queryTablaFavoritos = "CREATE TABLE "+ ConstantesBD.TABLE_NAME_FAVORITAS + "( " +
                ConstantesBD.TABLE_FAVORITAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_FAVORITAS_IDMASCOTA + " INTEGER, " +
                " FOREIGN KEY (" + ConstantesBD.TABLE_FAVORITAS_IDMASCOTA + ") " +
                " REFERENCES " + ConstantesBD.TABLE_NAME_MASCOTA + " ( "+ ConstantesBD.TABLE_MASCOTA_ID + ") " +
                " ) ";

        db.execSQL(queryTablaPetagram);
        db.execSQL(queryTablaLikes);
        db.execSQL(queryTablaFavoritos);

        db.beginTransaction();

        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE,"Blaze");
            contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota1);
            db.insert(ConstantesBD.TABLE_NAME_MASCOTA,null,contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE,"Firulais");
            contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota2);
            db.insert(ConstantesBD.TABLE_NAME_MASCOTA,null,contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE,"Payasa");
            contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota3);
            db.insert(ConstantesBD.TABLE_NAME_MASCOTA,null,contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE,"Zoro");
            contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota4);
            db.insert(ConstantesBD.TABLE_NAME_MASCOTA,null,contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE,"Tobi");
            contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota5);
            db.insert(ConstantesBD.TABLE_NAME_MASCOTA,null,contentValues);

            db.setTransactionSuccessful();

        }
        finally {
            db.endTransaction();
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBD.TABLE_NAME_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBD.TABLE_NAME_LIKES);
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBD.TABLE_NAME_FAVORITAS );
        onCreate(db);


    }

    public ArrayList<Mascota> obtenerMascota()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM "+ ConstantesBD.TABLE_NAME_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        while (cursor.moveToNext())
        {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(cursor.getInt(0));
            mascotaActual.setNombre(cursor.getString(1));
            mascotaActual.setFoto(cursor.getInt(2));

            mascotas.add(mascotaActual);


            String queryLikes  = "SELECT COUNT ("+ ConstantesBD.TABLE_LIKES_CANTIDAD+ ") AS LIKES "+
                    " FROM  " + ConstantesBD.TABLE_NAME_LIKES +
                    " WHERE " + ConstantesBD.TABLE_LIKES_IDMASCOTA + " = " + mascotaActual.getId();

            Cursor registrosLike = db.rawQuery(queryLikes,null);
            if(registrosLike.moveToNext()){
                mascotaActual.setCantidadLikes(registrosLike.getInt(0));
            }
            else mascotaActual.setCantidadLikes(0);
        }

        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM "+ ConstantesBD.TABLE_NAME_MASCOTA + " M INNER JOIN " +ConstantesBD.TABLE_NAME_FAVORITAS+ " F " +
                " ON M."+ConstantesBD.TABLE_MASCOTA_ID+ " = F."+ConstantesBD.TABLE_FAVORITAS_IDMASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        while (cursor.moveToNext())
        {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(cursor.getInt(0));
            mascotaActual.setNombre(cursor.getString(1));
            mascotaActual.setFoto(cursor.getInt(2));

            mascotas.add(mascotaActual);


            String queryLikes  = "SELECT COUNT ("+ ConstantesBD.TABLE_LIKES_CANTIDAD+ ") AS LIKES "+
                    " FROM  " + ConstantesBD.TABLE_NAME_LIKES +
                    " WHERE " + ConstantesBD.TABLE_LIKES_IDMASCOTA + " = " + mascotaActual.getId();

            Cursor registrosLike = db.rawQuery(queryLikes,null);
            if(registrosLike.moveToNext()){
                mascotaActual.setCantidadLikes(registrosLike.getInt(0));
            }
            else mascotaActual.setCantidadLikes(0);
        }

        db.close();
        return mascotas;
    }

    public void insertarFavorita(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD. TABLE_NAME_FAVORITAS,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_NAME_LIKES,null,contentValues);
        db.close();
    }

    public int obtenerNumeroRegistros(){
        int registros = 0;
        String query = "SELECT * FROM " + ConstantesBD.TABLE_NAME_FAVORITAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            registros++;
        }
        db.close();
        return registros;
    }

    public int obtenerPrimerRegistro(){
        int resultado = 0;
        String query = "SELECT * FROM " + ConstantesBD.TABLE_NAME_FAVORITAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToNext()){
            resultado = cursor.getInt(0);
        }
        db.close();
        return resultado;
    }

    public void eliminarRegistro(int id){
        String query =    ConstantesBD.TABLE_FAVORITAS_ID+" = " +id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(""+ConstantesBD.TABLE_NAME_FAVORITAS,query,null);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT ("+ ConstantesBD.TABLE_LIKES_CANTIDAD+ ") "+
                " FROM  " + ConstantesBD.TABLE_NAME_LIKES +
                " WHERE " + ConstantesBD.TABLE_LIKES_IDMASCOTA + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }


}
