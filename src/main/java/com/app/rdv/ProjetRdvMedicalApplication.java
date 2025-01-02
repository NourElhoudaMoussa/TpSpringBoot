package com.app.rdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.app.rdv")
public class ProjetRdvMedicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetRdvMedicalApplication.class, args);
    }

}
