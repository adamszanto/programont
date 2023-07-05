package com.example.restapp.controller;

import com.example.restapp.controller.dto.DoctorDto;
import com.example.restapp.mapper.DoctorMapper;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.service.DoctorService;
import com.example.restapp.service.model.Doctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public DoctorController(DoctorService doctorService, DoctorMapper doctorMapper, ModelMapper modelMapper) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
        this.modelMapper = modelMapper;
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

    @GetMapping("/even")
    public ResponseEntity<List<DoctorEntity>> getAllEvenIds() {
        List<DoctorEntity> doctors = doctorService.getAllDoctors();

        List<DoctorEntity> evenIdDoctors = doctors.stream()
                .filter(doctor -> doctor.getId() % 2 == 0)
                .collect(Collectors.toList());

        if (evenIdDoctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(evenIdDoctors);
    }

    @GetMapping("/prime")
    public ResponseEntity<List<DoctorEntity>> getAllPrimeIds() {
        List<DoctorEntity> doctors = doctorService.getAllDoctors();

        List<DoctorEntity> primeIdDoctors = doctors.stream()
                .filter(doctor -> isPrime(doctor.getId()))
                .collect(Collectors.toList());

        if (primeIdDoctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(primeIdDoctors);
    }
    private boolean isPrime(Long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        DoctorEntity doctorEntity = doctorService.findDoctorById(id);
        if(doctorEntity == null) {
            return ResponseEntity.notFound().build();
        }

        Doctor doctor = doctorMapper.convertEntityToModel(doctorEntity);
        DoctorDto doctorDto = doctorMapper.convertModelToDto(doctor);
        return ResponseEntity.ok(doctorDto);
    }

    @PostMapping()
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getDoctor().getName());
        doctor.setSpecialization(doctorDto.getDoctor().getSpecialization());
        doctor.setPatients(doctorDto.getDoctor().getPatients());

        Doctor savedDoctor = doctorService.createDoctor(doctorDto.getDoctor());
        DoctorDto convertedDoctor = doctorMapper.convertModelToDto(savedDoctor);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertedDoctor);
    }

    @PostMapping("/{id}/patients")
    public ResponseEntity<DoctorDto> addPatient(@PathVariable Long id, @RequestBody String patient) {

        Doctor updatedDoctor = doctorService.addPatient(id, patient);
        return ResponseEntity.ok(modelMapper.map(updatedDoctor, DoctorDto.class));
      //  return ResponseEntity.ok(doctorMapper.convertModelToDto(updatedDoctor));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctorName(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        DoctorEntity doctorEntity = doctorService.findDoctorById(id);
        String newName = requestBody.get("name");
        doctorEntity.setName(newName);

        Doctor doctor = doctorMapper.convertEntityToModel(doctorEntity);

        Doctor updatedDoctor = doctorService.createDoctor(doctor);
        DoctorDto doctorDto = doctorMapper.convertModelToDto(updatedDoctor);
        return ResponseEntity.ok(doctorDto);
    }

    // TODO
    // HTTP válaszok, nullpointert stb lekezelni
    // Üres param > Bad Request lekezelni
    // Redirect lekezelni
    // Válaszban milyen formátumban kapjuk az objektumot. DTO-t adjunk vissza.
    // Kapjunk vissza XML-t és JSON-t... ezt irányítva megadni.
    // Bemenő paraméter > komplex objektum, dtora mappelődik. POST metódus, lementeni az új doktort. 1 komplex JSON objektumban megkapni.
}
