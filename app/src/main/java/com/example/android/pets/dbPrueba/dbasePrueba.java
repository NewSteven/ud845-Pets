package com.example.android.pets.dbPrueba;

import android.provider.BaseColumns;

public class dbasePrueba {

    private String COLUMN_PET_NAME = "COLUMN_PET_NAME";
    private String COLUMN_PET_RAZA = "COLUMN_PET_RAZA";
    private String COLUMN_PET_GENERO = "COLUMN_PET_GENERO";
    private String COLUMN_PET_PESO = "COLUMN_PET_PESO";

    private int GENDER_UNKNOWN = 0;
    private int GENDER_MALE = 1;
    private int GENDER_FEMALE = 2;

    public dbasePrueba() {
    }

    public dbasePrueba( String COLUMN_PET_NAME, String COLUMN_PET_RAZA, String COLUMN_PET_GENERO, String COLUMN_PET_PESO ) {
        this.COLUMN_PET_NAME = COLUMN_PET_NAME;
        this.COLUMN_PET_RAZA = COLUMN_PET_RAZA;
        this.COLUMN_PET_GENERO = COLUMN_PET_GENERO;
        this.COLUMN_PET_PESO = COLUMN_PET_PESO;

    }

    public void setCOLUMN_PET_NAME(String COLUMN_PET_NAME) {
        this.COLUMN_PET_NAME = COLUMN_PET_NAME;
    }

    public void setCOLUMN_PET_RAZA(String COLUMN_PET_RAZA) {
        this.COLUMN_PET_RAZA = COLUMN_PET_RAZA;
    }

    public void setCOLUMN_PET_GENERO(String COLUMN_PET_GENERO) {
        this.COLUMN_PET_GENERO = COLUMN_PET_GENERO;
    }

    public void setCOLUMN_PET_PESO(String COLUMN_PET_PESO) {
        this.COLUMN_PET_PESO = COLUMN_PET_PESO;
    }

    public void setGENDER_UNKNOWN(int GENDER_UNKNOWN) {
        this.GENDER_UNKNOWN = GENDER_UNKNOWN;
    }

    public void setGENDER_MALE(int GENDER_MALE) {
        this.GENDER_MALE = GENDER_MALE;
    }

    public void setGENDER_FEMALE(int GENDER_FEMALE) {
        this.GENDER_FEMALE = GENDER_FEMALE;
    }

    public String getCOLUMN_PET_NAME() {
        return COLUMN_PET_NAME;
    }

    public String getCOLUMN_PET_RAZA() {
        return COLUMN_PET_RAZA;
    }

    public String getCOLUMN_PET_GENERO() {
        return COLUMN_PET_GENERO;
    }

    public String getCOLUMN_PET_PESO() {
        return COLUMN_PET_PESO;
    }

    public int getGENDER_UNKNOWN() {
        return GENDER_UNKNOWN;
    }

    public int getGENDER_MALE() {
        return GENDER_MALE;
    }

    public int getGENDER_FEMALE() {
        return GENDER_FEMALE;
    }
}
