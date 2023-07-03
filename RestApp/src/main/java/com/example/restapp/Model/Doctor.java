package com.example.restapp.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor extends Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String specialization;
    @ElementCollection
    private List<String> patients;

    public Doctor() {
        this.specialization = "General Practitioner";
        this.patients = new ArrayList<>();
    }
}
