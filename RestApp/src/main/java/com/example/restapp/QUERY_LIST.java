package com.example.restapp;

public final class QUERY_LIST {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM doctors WHERE id = :id";
    public static final String QUERY_DELETE_PATIENTS = "DELETE FROM patients";
    public static final String QUERY_DELETE_DOCTORS =  "DELETE FROM doctors";
}
