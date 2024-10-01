package com.app.rdv.service;

import com.app.rdv.entities.Medecin;

import java.util.List;


public interface IServiceMedecin {
    Medecin createMedecin(Medecin medecin);
    List<Medecin> readAllMedecin();

}
