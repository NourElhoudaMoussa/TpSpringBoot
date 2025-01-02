package com.app.rdv.security.controller;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;
import com.app.rdv.security.service.IServiceAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class AuthenticationController {
    private IServiceAuthentication serviceAuthentication;

    @PostMapping("addAppUser")
    public ResponseEntity<Object> addAppUser(@RequestBody AppUser appUser){
        AppUser save_appUser=serviceAuthentication.createAppUser(appUser);
        if(save_appUser!=null){
            return new ResponseEntity<>(save_appUser, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("ce user avec ce username existe deja ",HttpStatus.CONFLICT);
        }
    }

    @PostMapping("addAppRole")
    public ResponseEntity<Object> addAppRole(@RequestBody AppRole appRole){
        AppRole save_appRole=serviceAuthentication.createAppRole(appRole);
        if(save_appRole!=null){
            return new ResponseEntity<>(save_appRole, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("ce role existe deja ",HttpStatus.CONFLICT);
        }
    }

    @PostMapping("addRoleToUser")
    public ResponseEntity<Object> addRoleToUser(@RequestParam String role, @RequestParam String username){
        Boolean isValid=serviceAuthentication.addRoleToUser(username,role);
        if(isValid){
            return new ResponseEntity<>("role added to "+username+" Successfuly ", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("probleme lors de l'ajout du role ",HttpStatus.CONFLICT);
        }
    }


}
