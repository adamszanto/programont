package com.example.restapp.controller;

import com.example.restapp.controller.dto.DoctorDto;
import com.example.restapp.mapper.DoctorMapper;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorController(DoctorService doctorService, DoctorMapper doctorMapper) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
    }

    @GetMapping("/auth")
    public String testRequestHeader (@RequestHeader String authorization) {
        System.out.println("printing the auth " + authorization);
        return "Success";
    }

    @GetMapping()
    public ResponseEntity<List<DoctorEntity>> getAllDoctors() {
        List<DoctorEntity> doctors = doctorService.getAllDoctors();
        if(doctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        DoctorEntity doctor = doctorService.findDoctorById(id);
        if(doctor == null) {
            return ResponseEntity.notFound().build();
        }
        DoctorDto doctorDto = doctorMapper.convertEntityToDto(doctor);
        return ResponseEntity.ok(doctorDto);
    }

    @PostMapping()
    public ResponseEntity<DoctorDto> createDoctor(@RequestParam String name) {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setName(name);
        DoctorEntity savedDoctor = doctorService.saveDoctor(doctor);
        DoctorDto savedDoctorDto = doctorMapper.convertEntityToDto(savedDoctor);
        return new ResponseEntity<>(savedDoctorDto, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/patients")
    public ResponseEntity<DoctorDto> addPatient(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        DoctorEntity doctor = doctorService.findDoctorById(id);
        String patientName = requestBody.get("patientName");
        doctor.getPatients().add(patientName);
        DoctorEntity updatedDoctor = doctorService.saveDoctor(doctor);
        DoctorDto updatedDoctorDto = doctorMapper.convertEntityToDto(updatedDoctor);
        return ResponseEntity.ok(updatedDoctorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DoctorEntity> updateDoctorName(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        DoctorEntity doctor = doctorService.findDoctorById(id);
        String newName = requestBody.get("name");
        doctor.setName(newName);
        DoctorEntity updatedDoctor = doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(updatedDoctor);

    }

    // TODO
    // HTTP válaszok, nullpointert stb lekezelni
    // Üres param > Bad Request lekezelni
    // Redirect lekezelni
    // Válaszban milyen formátumban kapjuk az objektumot. DTO-t adjunk vissza.
    // Kapjunk vissza XML-t és JSON-t... ezt irányítva megadni.
    // Bemenő paraméter > komplex objektum, dtora mappelődik. POST metódus, lementeni az új doktort. 1 komplex JSON objektumban megkapni.
}
