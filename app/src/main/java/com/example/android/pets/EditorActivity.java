package com.example.android.pets;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.pets.data.PetContract;
import com.example.android.pets.data.PetDbHelper;

import com.example.android.pets.utilidades.utilidadesPruebita;

import java.util.ArrayList;

/**
 * Allows user to create a new pet or edit an existing one.
 */
public class EditorActivity extends AppCompatActivity {

    private PetDbHelper mDbHelper;
    /** EditText field to enter the pet's name */
    private EditText mNameEditText;

    /** EditText field to enter the pet's breed */
    private EditText mBreedEditText;

    /** EditText field to enter the pet's weight */
    private EditText mWeightEditText;

    /** EditText field to enter the pet's gender */
    private Spinner mGenderSpinner;


    /**
     * Gender of the pet. The possible values are:
     * 0 for unknown gender, 1 for male, 2 for female.
     */
    private int mGender = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mNameEditText = (EditText) findViewById(R.id.edit_pet_name);
        mBreedEditText = (EditText) findViewById(R.id.edit_pet_breed);
        mWeightEditText = (EditText) findViewById(R.id.edit_pet_weight);
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);

        setupSpinner();// espiner
        mDbHelper = new PetDbHelper(this);

    }

    private void setupSpinner() {
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = utilidadesPruebita.GENDER_MALE; // Male
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        mGender = utilidadesPruebita.GENDER_FEMALE; // Female
                    } else {
                        mGender = utilidadesPruebita.GENDER_UNKNOWN; // Unknown
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 0; // Unknown
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                insertPet();
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertPet(){
        conexionSQLiteHelper conexxion = new conexionSQLiteHelper(this, "baseDatosMascotas", null, 1);
        SQLiteDatabase baseDatos = conexxion.getWritableDatabase();

        String nombre = mNameEditText.getText().toString();
        String raza= mBreedEditText.getText().toString();
        int peso = Integer.parseInt( mWeightEditText.getText().toString());

            ContentValues values = new ContentValues();

            values.put(utilidadesPruebita.COLUMN_PET_NAME, nombre);
            values.put(utilidadesPruebita.COLUMN_PET_RAZA, raza);
            values.put(utilidadesPruebita.COLUMN_PET_GENERO, mGender);
            values.put(utilidadesPruebita.COLUMN_PET_PESO, peso);

            // ID == -1 -> Error, ID == 1 -> Success
            long ID = baseDatos.insert(utilidadesPruebita.tabla_usuario, null, values);
            if(ID == -1) Toast.makeText(this,"Error with inserting pet",Toast.LENGTH_SHORT).show();
            else  Toast.makeText(this,"Pet created!",Toast.LENGTH_SHORT).show();

    }
    /*
    private void insertPet(){
        String name = mNameEditText.getText().toString();
        String breed = mBreedEditText.getText().toString();
        int weight = Integer.parseInt( mWeightEditText.getText().toString());

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PetContract.PetEntry.COLUMN_PET_NAME, name);
        values.put(PetContract.PetEntry.COLUMN_PET_BREED, breed);
        values.put(PetContract.PetEntry.COLUMN_PET_GENDER, mGender);
        values.put(PetContract.PetEntry.COLUMN_PET_WEIGHT, weight);
        // ID == -1 -> Error, ID == 1 -> Success
        long ID = db.insert(PetContract.PetEntry.TABLE_NAME, null, values);
        if(ID == -1) Toast.makeText(this,"Error with inserting pet",Toast.LENGTH_SHORT).show();
        else  Toast.makeText(this,"Pet created!",Toast.LENGTH_SHORT).show();
    }*/

/*
        String insert="INSERT INTO "+utilidadesPruebita.tabla_usuario +"(" + utilidadesPruebita.COLUMN_PET_NAME+","+ utilidadesPruebita.COLUMN_PET_RAZA+","+utilidadesPruebita.COLUMN_PET_GENERO+","+utilidadesPruebita.COLUMN_PET_PESO+")"+ "VALUES ('"+ mNameEditText.getText().toString()+"','"+mBreedEditText.getText().toString()+"',"+mGender+"','"+Integer.parseInt( mWeightEditText.getText().toString())+"')";

        baseDatos.execSQL(insert);

        baseDatos.close();
*/
    
}