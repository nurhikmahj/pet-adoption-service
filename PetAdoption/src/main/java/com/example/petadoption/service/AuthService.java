package com.example.petadoption.service;

import com.example.petadoption.data.model.AdopterProfileRepository;
import com.example.petadoption.data.request.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    private final AdopterProfileRepository adopterProfileRepository;
    private final ModelMapper modelMapper;

    public AuthService(AdopterProfileRepository adopterProfileRepository, ModelMapper modelMapper) {
        this.adopterProfileRepository = adopterProfileRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<?> login (LoginRequest request) {

    }

}
