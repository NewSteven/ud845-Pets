package com.example.android.pets.utilidades;

import android.provider.BaseColumns;

import com.example.android.pets.dbPrueba.dbasePrueba;

public class utilidadesPruebita {

    public final static String tabla_usuario = "Mascotas";

    //public final static int IDx = 1;
    public final static String COLUMN_PET_NAME = "COLUMN_PET_NAME";
    public final static String COLUMN_PET_RAZA = "COLUMN_PET_RAZA";
    public final static String COLUMN_PET_GENERO = "COLUMN_PET_GENERO";
    public final static String COLUMN_PET_PESO = "COLUMN_PET_PESO";

    public static final int GENDER_UNKNOWN = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;

    public static final String Create_Table_Usuario = "CREATE TABLE " + tabla_usuario + " ("+  COLUMN_PET_NAME +" text, " + COLUMN_PET_RAZA +" Text, "+COLUMN_PET_GENERO+" Text, " + COLUMN_PET_PESO + "text)";
}
