package com.app.rdv.service;

import com.app.rdv.entities.Medecin;
import com.app.rdv.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceMedecin implements IServiceMedecin{
    private final MedecinRepository medecinRepository;
    @Override
    public Medecin createMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public List<Medecin> readAllMedecin() {
        return medecinRepository.findAll();
    }
}
