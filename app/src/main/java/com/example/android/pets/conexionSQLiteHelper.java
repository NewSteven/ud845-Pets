package com.example.android.pets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.android.pets.utilidades.utilidadesPruebita;


public class conexionSQLiteHelper extends SQLiteOpenHelper {
    public conexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase databasex) {
      databasex.execSQL(utilidadesPruebita.Create_Table_Usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase databasex, int i, int i1) {
        databasex.execSQL("DROP TABLE IF EXISTS baseDatosMascotas");
        onCreate(databasex);
    }
}
