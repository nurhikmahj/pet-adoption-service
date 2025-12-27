package com.example.petadoption.controller;

import com.example.petadoption.data.request.UserRequest;
import com.example.petadoption.data.response.RetrieveUserResponse;
import com.example.petadoption.data.response.UserResponse;
import com.example.petadoption.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

    private final UserProfileService userProfileService;

    public UserController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping(value = "/createUser")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userProfileService.createUserProfile(userRequest);
    }

    @PutMapping("/updateUser/{userId}")
    public String updateUser(@PathVariable String userId, @RequestBody UserRequest userRequest) {
        return userProfileService.updateUserProfile(userId, userRequest);
    }

    @GetMapping(value = "/getUser/{userId}")
    public RetrieveUserResponse getUser(@PathVariable String userId) {
        return userProfileService.getUserProfile(userId);
    }

    @GetMapping(value = "/getUser/all")
    public List<RetrieveUserResponse> getAllUsers() {
        return userProfileService.getAllUserProfile();
    }

    @DeleteMapping(value = "/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return userProfileService.deleteUser(userId);
    }
}
