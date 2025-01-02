package com.app.rdv.security.service;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;
import com.app.rdv.security.repositories.AppRoleRepository;
import com.app.rdv.security.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ServiceAuthentication implements IServiceAuthentication {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public AppUser createAppUser(AppUser appUser) {
        AppUser existingAppUser=appUserRepository.findByUsername(appUser.getUsername());
        if(existingAppUser==null){
            appUser.setPassword(passwordEncoder().encode(appUser.getPassword()));
            return appUserRepository.save(appUser);
        }
        else {
            return null;
        }
    }

    @Override
    public AppRole createAppRole(AppRole appRole) {
        AppRole existingAppRole=appRoleRepository.findByRole(appRole.getRole());
        if(existingAppRole==null){
            return appRoleRepository.save(appRole);
        }else {
            return null;
        }
    }

    @Override
    public Boolean addRoleToUser(String username, String role) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRole(role);
        if(appUser!=null){
            if(appRole!=null){
                appUser.getRole().add(appRole);
                appUserRepository.save(appUser);
                return true;
            }else {
                return false;
            }

        }else {
            return false;
        }
    }

    @Override
    public AppUser LoadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
