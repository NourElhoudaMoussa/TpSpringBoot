package com.app.rdv.service;

import com.app.rdv.entities.Medecin;
import com.app.rdv.entities.Patient;
import com.app.rdv.entities.Rdv;
import com.app.rdv.repository.RdvRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
//@AllArgsConstructor
@RequiredArgsConstructor
@Service
public class ServiceRdv implements IServiceRdv{
    private final RdvRepository rdvRepository;
    @Override
    public Rdv createRdv(Rdv rdv) {
        return rdvRepository.save(rdv);
    }
    @Override
    public List<Rdv> readAllRdv() {
        return rdvRepository.findAll();
    }

    @Override
    public Rdv GetRdvByMedecinAndDateRdv(Medecin medecin, LocalDateTime dateRdv) {
        return rdvRepository.findRdvByMedecinAndDateRdv(medecin,dateRdv);
    }
    @Override
    public Rdv GetRdvByPatientAndDateRdv(Patient patient, LocalDateTime dateRdv) {
        return rdvRepository.findRdvByPatientAndDateRdv(patient,dateRdv);
    }

    @Override
    public List<Rdv> GetAllByDateRdv(LocalDateTime dateRdv) {
        return rdvRepository.findAllByDateRdv(dateRdv);
    }


}
