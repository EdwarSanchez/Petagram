package com.example.telmex.petagram.db;

/**
 * Created by telmex on 20/04/2017.
 */

public class ConstantesBD {
    //Nombre de la base de datos
    public static final String DATABASE_NAME = "MASCOTA";

    //Version de la base de datos
    public static int  DATABASE_VERSION = 1;

    //Nombre de la tabla PETAGRAM y sus columnas id, nombre, foto
    public static String TABLE_NAME_MASCOTA = "PETAGRAM";
    public static String TABLE_MASCOTA_ID = "id";
    public static String TABLE_MASCOTA_NOMBRE = "nombre";
    public static String TABLE_MASCOTA_FOTO = "foto";

    //Nombre de la tabla LIKES y sus columnas idLike, idMascota y cantidadLikes
    public static String TABLE_NAME_LIKES = "LIKES";
    public static String TABLE_LIKES_ID = "idLike";
    public static String TABLE_LIKES_IDMASCOTA = "idPetagram";
    public static String TABLE_LIKES_CANTIDAD = "cantidad";

    //Nombre de la tabla de las 5 mascotas gustadas en el momento
    public static String TABLE_NAME_FAVORITAS = "FAVORITAS";
    public static String TABLE_FAVORITAS_ID = "idFavoritas";
    public static String TABLE_FAVORITAS_IDMASCOTA = "idMascota";





}
