package com.app.rdv.service;

import com.app.rdv.entities.Patient;
import com.app.rdv.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ServicePatient implements IServicePatient{
    private final PatientRepository patientRepository;
    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> readAllPatient() {
        return patientRepository.findAll();
    }
}
