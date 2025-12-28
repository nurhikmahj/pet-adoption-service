package com.example.petadoption.controller;

import com.example.petadoption.data.request.AdopterRequest;
import com.example.petadoption.data.response.RetrieveUserResponse;
import com.example.petadoption.data.response.UserResponse;
import com.example.petadoption.service.AdopterProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/user")
public class UserController {

    private final AdopterProfileService adopterProfileService;

    public UserController(AdopterProfileService adopterProfileService) {
        this.adopterProfileService = adopterProfileService;
    }

    @PostMapping(value = "/createUser")
    public UserResponse createUser(@RequestBody AdopterRequest adopterRequest) {
        return adopterProfileService.createadopterProfile(adopterRequest);
    }

    @PutMapping("/updateUser/{userId}")
    public String updateUser(@PathVariable String userId, @RequestBody AdopterRequest adopterRequest) {
        return adopterProfileService.updateAdopterProfile(userId, adopterRequest);
    }

    @GetMapping(value = "/getUser/{userId}")
    public RetrieveUserResponse getUser(@PathVariable String userId) {
        return adopterProfileService.getadopterProfile(userId);
    }

    @GetMapping(value = "/getUser/all")
    public List<RetrieveUserResponse> getAllUsers() {
        return adopterProfileService.getAlladopterProfile();
    }

    @DeleteMapping(value = "/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return adopterProfileService.deleteUser(userId);
    }
}
