package com.app.rdv.security.repositories;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    public AppUser findByUsername(String username);
}
