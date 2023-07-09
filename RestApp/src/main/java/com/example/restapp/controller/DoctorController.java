package com.example.restapp.controller;

import com.example.restapp.controller.dto.DoctorDto;
import com.example.restapp.controller.dto.PatientDto;
import com.example.restapp.exception.DoctorValidationException;
import com.example.restapp.mapper.DoctorMapper;
import com.example.restapp.mapper.mapstruct.MapStructImpl;
import com.example.restapp.service.DoctorService;
import com.example.restapp.service.model.Doctor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;
    private final ModelMapper modelMapper;
    private final MapStructImpl mapStructImpl;

    private final static String EMPTY_LIST_MESSAGE = "There are no doctors currently on the list.";

    public DoctorController(DoctorService doctorService, DoctorMapper doctorMapper, ModelMapper modelMapper, MapStructImpl mapStructImpl) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
        this.modelMapper = modelMapper;
        this.mapStructImpl = mapStructImpl;
    }

    @GetMapping("/auth")
    public String testRequestHeader (@RequestHeader String authorization) {
        String response = "Success! Printing the auth: ";
        return response + authorization;
    }

    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        String response = EMPTY_LIST_MESSAGE;
        HttpStatus status = HttpStatus.NOT_FOUND;

        if(!doctors.isEmpty()) {
            return ResponseEntity.ok(doctors);
        }
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/criteria/{num}")
    public ResponseEntity<List<Doctor>> getIdGreaterThan(@PathVariable Integer num) {
        List<Doctor> doctors = doctorService.findByIdGreaterThan(num);
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
    public ResponseEntity<String> getDoctorCount() {
        Long count = doctorService.getDoctorCount();
        String response = EMPTY_LIST_MESSAGE;
        HttpStatus status = HttpStatus.NOT_FOUND;

        if(count > 0) {
            response = "Number of doctors: " + count + ".";
            status = HttpStatus.OK;
        }

        return ResponseEntity.status(status).body(response);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDto> createDoctorJson(@RequestBody DoctorDto doctorDto) {
//        Doctor savedDoctor = doctorService.createDoctor(doctorDto.getDoctor());
//        DoctorDto convertedDoctor = doctorMapper.convertModelToDto(savedDoctor);
        Doctor savedDoctor = doctorService.createDoctorWithModelMapper(doctorDto.getDoctor());
        DoctorDto convertedDoctor = modelMapper.map(savedDoctor, DoctorDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertedDoctor);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DoctorDto> createDoctorXml(@RequestBody DoctorDto doctorDto) {
//        Doctor savedDoctor = doctorService.createDoctor(doctorDto.getDoctor());
//        DoctorDto convertedDoctor = doctorMapper.convertModelToDto(savedDoctor);
        Doctor savedDoctor = doctorService.createDoctorWithMapStruct(doctorDto.getDoctor());
        DoctorDto convertedDoctor = mapStructImpl.convertModelToDto(savedDoctor);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertedDoctor);
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto, @RequestParam(defaultValue = "json") String format) {
        if(format.equalsIgnoreCase("xml")) {
            return createDoctorXml(doctorDto);
        } else {
            return createDoctorJson(doctorDto);
        }
    }


    @PostMapping(value = "/{id}/patients", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPatientJson(@PathVariable Long id, @RequestBody PatientDto patientDto) throws DoctorValidationException {
        try {
            Doctor updatedDoctor = doctorService.addPatient(id, patientDto.getPatient().getName(), patientDto.getPatient().getBirthDate());
            return ResponseEntity.ok(modelMapper.map(updatedDoctor, DoctorDto.class));
        } catch (Exception e) {
            String errorMessage = "Cannot find Doctor with given id: " + id;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping(value = "/{id}/patients", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addPatientXml(@PathVariable Long id, @RequestBody PatientDto patientDto) throws DoctorValidationException {
        try {
            Doctor updatedDoctor = doctorService.addPatient(id, patientDto.getPatient().getName(), patientDto.getPatient().getBirthDate());
            return ResponseEntity.ok(modelMapper.map(updatedDoctor, DoctorDto.class));
        } catch (Exception e) {
            String errorMessage = "Cannot find Doctor with given id: " + id;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping("/{id}/patients")
    public ResponseEntity<?> addPatient(@PathVariable Long id, @RequestBody PatientDto patientDto, @RequestParam(defaultValue = "json") String format) throws DoctorValidationException {
        if(format.equalsIgnoreCase("xml")) {
            return addPatientXml(id, patientDto);
        } else {
            return addPatientJson(id, patientDto);
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
