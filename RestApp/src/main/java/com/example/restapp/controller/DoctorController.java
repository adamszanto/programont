package com.example.restapp.controller;

import com.example.restapp.controller.dto.DoctorDto;
import com.example.restapp.controller.dto.PatientDto;
import com.example.restapp.exception.DoctorValidationException;
import com.example.restapp.mapper.DoctorMapper;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.service.DoctorService;
import com.example.restapp.service.model.Doctor;
import com.google.protobuf.Empty;
import org.modelmapper.ModelMapper;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.print.Doc;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;
    private final ModelMapper modelMapper;

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

    @GetMapping
    public ResponseEntity<List<Doctor>> getallDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();


        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/even")
    public ResponseEntity<List<Doctor>> getAllEvenIds() {
        List<Doctor> doctors = doctorService.getAllDoctors();

        List<Doctor> evenIdDoctors = doctors.stream()
                .filter(doctor -> doctor.getId() % 2 == 0)
                .collect(Collectors.toList());

        if (evenIdDoctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(evenIdDoctors);
    }


    @GetMapping("/prime")
    public ResponseEntity<List<Doctor>> getAllPrimeIds() {
        List<Doctor> doctors = doctorService.getAllDoctors();

        List<Doctor> primeIdDoctors = doctors.stream()
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


    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) throws DoctorValidationException {
        try {

            Doctor doctor = doctorService.findDoctorById(id);
            if (doctor == null) {
                throw new DoctorValidationException("Cannot find doctor with id: " + id);
            }

            DoctorDto doctorDto = doctorMapper.convertModelToDto(doctor);
            return ResponseEntity.ok(doctorDto);
        } catch (DoctorValidationException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(value = "/customrepo/{id}")
    public ResponseEntity<?> customGetDoctorById(@PathVariable Long id) throws DoctorValidationException {
        try {

            Doctor doctor = doctorService.customFindDoctorById(id);
            if (doctor == null) {
                throw new DoctorValidationException("Cannot find doctor with id: " + id);
            }

            DoctorDto doctorDto = doctorMapper.convertModelToDto(doctor);
            return ResponseEntity.ok(doctorDto);
        } catch (DoctorValidationException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(value ="/nativequery/{id}")
    public ResponseEntity<?> nativeGetDoctorById(@PathVariable Long id) throws DoctorValidationException {
        try {

            Doctor doctor = doctorService.nativeFindDoctorById(id);
            if (doctor == null) {
                throw new DoctorValidationException("Cannot find doctor with id: " + id);
            }

            DoctorDto doctorDto = doctorMapper.convertModelToDto(doctor);
            return ResponseEntity.ok(doctorDto);
        } catch (DoctorValidationException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping(value ="/nativequery")
    public ResponseEntity<?> nativeDeleteAll(){
        try {
            doctorService.nativeDeleteAll();
            return ResponseEntity.ok("All doctors deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occurred while deleting all doctors");
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getDoctorCount() {
        Long count = doctorService.getDoctorCount();
        return ResponseEntity.ok(count);
    }


    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        Doctor savedDoctor = doctorService.createDoctor(doctorDto.getDoctor());
        DoctorDto convertedDoctor = doctorMapper.convertModelToDto(savedDoctor);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertedDoctor);
    }


    @PostMapping("/{id}/patients")
    public ResponseEntity<?> addPatient(@PathVariable Long id, @RequestBody PatientDto patientDto) throws DoctorValidationException {
        try {
            Doctor updatedDoctor = doctorService.addPatient(id, patientDto.getPatient().getName(), patientDto.getPatient().getBirthDate());
            return ResponseEntity.ok(modelMapper.map(updatedDoctor, DoctorDto.class));
        } catch (Exception e) {
            String errorMessage = "Cannot find Doctor with given id: " + id;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllDoctor(){
        try {
            doctorService.deleteAllDoctor();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctorName(@PathVariable Long id, @RequestBody String name) {
        Doctor doctor = doctorService.findDoctorById(id);
        doctor.setName(name);

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
