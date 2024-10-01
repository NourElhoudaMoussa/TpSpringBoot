package com.app.rdv.controller;

import com.app.rdv.entities.Rdv;
import com.app.rdv.service.IServiceRdv;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rdv/")
public class RdvRestController {
    private IServiceRdv iServiceRdv;

    @PostMapping("add")
    public String  add(@RequestBody Rdv rdv){
        Rdv exictinRdvMesecin = iServiceRdv.GetRdvByMedecinAndDateRdv(rdv.getMedecin(),rdv.getDateRdv());
        Rdv exictinRdvPatient = iServiceRdv.GetRdvByPatientAndDateRdv(rdv.getPatient(),rdv.getDateRdv());
        if (exictinRdvMesecin==null && exictinRdvPatient==null){
            iServiceRdv.createRdv(rdv);
            return "Rdv est reserver avec succées";
        }else if(exictinRdvMesecin==null && exictinRdvPatient!=null){
            return "le patient a déja un rdv dans se temps";
        }else if(exictinRdvMesecin!=null && exictinRdvPatient==null){
            return "le medecin a déja un rdv dans se temps";
        }else {
            return "le medecin et le patient ont déja un rdv dans se temps";
        }

    }

    @GetMapping("all")
    public List<Rdv> allRdv(){
        return iServiceRdv.readAllRdv();
    }

    @GetMapping("RdvByDateRdv")
    private List<Rdv> RdvByDateRdv(@RequestBody LocalDateTime dateRdv){
        return iServiceRdv.GetAllByDateRdv(dateRdv);
    }
}
