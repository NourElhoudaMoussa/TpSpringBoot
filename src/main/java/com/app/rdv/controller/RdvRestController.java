package com.app.rdv.controller;

import com.app.rdv.entities.Rdv;
import com.app.rdv.service.IServiceRdv;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rdv/")
public class RdvRestController {
    private IServiceRdv iServiceRdv;

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody Rdv rdv){
        Rdv save_rdv= iServiceRdv.createRdv(rdv);
        if(save_rdv!=null){
            return new ResponseEntity<>(save_rdv, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Le RDV ne pas être créer ",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("all")
    public List<Rdv> allRdv(){
        return iServiceRdv.readAllRdv();
    }

    @GetMapping("RdvOrderByDateRdv")
    private List<Rdv> RdvOrderbyDateRdv(){
        return iServiceRdv.GetAllByDateRdv();
    }
}
