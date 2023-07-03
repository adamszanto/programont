package com.example.restapp.controller;

import com.example.restapp.Repository.entity.Doctor;
import com.example.restapp.service.DoctorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.findDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping()
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @PostMapping()
    public ResponseEntity<Doctor> createDoctor(@RequestParam String name) {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/patients")
    public ResponseEntity<Doctor> addPatient(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        Doctor doctor = doctorService.findDoctorById(id);
        String patientName = requestBody.get("patientName");
        doctor.getPatients().add(patientName);
        Doctor updatedDoctor = doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
