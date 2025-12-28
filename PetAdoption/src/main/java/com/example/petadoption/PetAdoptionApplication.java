package com.example.petadoption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
public class PetAdoptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetAdoptionApplication.class, args);
        System.out.println("Pet Adoption Application Started");
    }

}
