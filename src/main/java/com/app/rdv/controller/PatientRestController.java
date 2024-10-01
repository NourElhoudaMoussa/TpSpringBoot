package com.app.rdv.controller;

import com.app.rdv.entities.Patient;
import com.app.rdv.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patient/")
public class PatientRestController {
    private IServicePatient iServicePatient;

    @PostMapping("add")
    public Patient add(@RequestBody Patient patient){
        return iServicePatient.createPatient(patient);
    }

    @GetMapping("all")
    public List<Patient> allPatient(){
        return iServicePatient.readAllPatient();
    }
}
