package com.example.android.pets;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.android.pets.data.PetContract;
import com.example.android.pets.data.PetDbHelper;

import java.util.ArrayList;
import com.example.android.pets.dbPrueba.dbasePrueba;
import com.example.android.pets.utilidades.utilidadesPruebita;

public class recyclerViewx extends AppCompatActivity {

    private PetDbHelper mDbHelper;

    ArrayList<dbasePrueba> listaDatos;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_viewx);

        mDbHelper = new PetDbHelper(this);

        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        listaDatos = new ArrayList<>();

        consularDatos();

    }

    private void consularDatos() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        dbasePrueba usuario = null;
        listaDatos = new ArrayList<>();

        // Perform a query on the pets table
        Cursor cursor = db.rawQuery("select * from " + PetContract.PetEntry.TABLE_NAME, null );

        while (cursor.moveToNext()){

            usuario = new dbasePrueba();

            usuario.setCOLUMN_PET_NAME(utilidadesPruebita.COLUMN_PET_NAME);
            usuario.setCOLUMN_PET_RAZA(utilidadesPruebita.COLUMN_PET_RAZA);
            usuario.setCOLUMN_PET_GENERO(utilidadesPruebita.COLUMN_PET_GENERO);
            usuario.setCOLUMN_PET_PESO(utilidadesPruebita.COLUMN_PET_PESO);
            listaDatos.add(usuario);
        }

    }
}
