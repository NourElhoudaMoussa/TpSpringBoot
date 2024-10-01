package com.app.rdv.controller;

import com.app.rdv.entities.Medecin;
import com.app.rdv.service.IServiceMedecin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/medecin/")
public class MedecinRestController {
    private IServiceMedecin iServiceMedecin;

    @PostMapping("add")
    public Medecin add(@RequestBody Medecin medecin){
        return iServiceMedecin.createMedecin(medecin);
    }

    @GetMapping("all")
    public List<Medecin> allMedecin(){
        return iServiceMedecin.readAllMedecin();
    }
}
