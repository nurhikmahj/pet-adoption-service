package com.example.petadoption.service;

import com.example.petadoption.data.model.UserProfile;
import com.example.petadoption.data.model.UserProfileRepository;
import com.example.petadoption.data.request.UserRequest;
import com.example.petadoption.data.response.RetrieveUserResponse;
import com.example.petadoption.data.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final ModelMapper modelMapper;

    public UserProfileService(UserProfileRepository userProfileRepository, ModelMapper modelMapper) {
        this.userProfileRepository = userProfileRepository;
        this.modelMapper = modelMapper;
    }

    public UserResponse createUserProfile(UserRequest userRequest) {
        try {
            UserProfile userProfile = UserProfile.builder()
                    .userProfileId(UUID.randomUUID().toString())
                    .userName(userRequest.getUserName())
                    .userNric(userRequest.getUserId())
                    .userAddress(userRequest.getUserAddress())
                    .petOwnerFlag(userRequest.getPetOwnerFlag())
                    .petId(userRequest.getPetId())
                    .build();

            userProfileRepository.save(userProfile);
            return UserResponse.builder().status("success").userId(userRequest.getUserId()).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return UserResponse.builder().status("fail").userId(userRequest.getUserId()).build();
        }
    }

    public RetrieveUserResponse getUserProfile(String userId) {
        try {
            UserProfile user = userProfileRepository.findByUserNric(userId);
            return modelMapper.map(user, RetrieveUserResponse.class);

        } catch (Exception e ) {
            log.error(e.getMessage());
            return null;
        }
    }

    public List<RetrieveUserResponse> getAllUserProfile() {
        try {
            List<UserProfile> userProfiles = userProfileRepository.findAllByOrderByUserName();
            List<RetrieveUserResponse> responses = new ArrayList<>();
            for (UserProfile userProfile : userProfiles) {
                responses.add(modelMapper.map(userProfile, RetrieveUserResponse.class));
            }

            return responses;

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public String updateUserProfile(String userId, UserRequest userRequest) {
        try {

            UserProfile user = userProfileRepository.findByUserNric(userId);
            modelMapper.map(userRequest, user);
            userProfileRepository.save(user);
            return "success";

        } catch (Exception e) {
            log.error(e.getMessage());
            return "Fail to update user profile";
        }
    }

    public String deleteUser(String userId) {
        try {
            UserProfile user = userProfileRepository.findByUserNric(userId);
            userProfileRepository.delete(user);
            return "User deleted successfully";

        } catch (Exception e) {
            log.error(e.getMessage());
            return "Fail to delete user profile";
        }
    }


}
