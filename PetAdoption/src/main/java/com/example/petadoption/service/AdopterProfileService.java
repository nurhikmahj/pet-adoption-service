package com.example.petadoption.service;

import com.example.petadoption.data.model.AdopterProfile;
import com.example.petadoption.data.model.AdopterProfileRepository;
import com.example.petadoption.data.request.AdopterRequest;
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
public class AdopterProfileService {

    private final AdopterProfileRepository adopterProfileRepository;
    private final ModelMapper modelMapper;

    public AdopterProfileService(AdopterProfileRepository adopterProfileRepository, ModelMapper modelMapper) {
        this.adopterProfileRepository = adopterProfileRepository;
        this.modelMapper = modelMapper;
    }

    public UserResponse createAdopterProfile(AdopterRequest adopterRequest) {
        try {
            AdopterProfile adopterProfile = AdopterProfile.builder()
                    .id(UUID.randomUUID().toString())
                    .adpName(adopterRequest.getAdpName())
                    .adpIdNo(adopterRequest.getAdpIdNo())
                    .adpAddress(adopterRequest.getAdpAddress())
                    .adpContact(adopterRequest.getAdpContactNo())
                    .petOwnerFlag(adopterRequest.getPetOwnerFlag())
                    .petId(adopterRequest.getPetId())
                    .build();

            adopterProfileRepository.save(adopterProfile);
            return UserResponse.builder().status("success").userId(adopterRequest.getAdpIdNo()).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return UserResponse.builder().status("fail").userId(adopterRequest.getAdpIdNo()).build();
        }
    }

    public RetrieveUserResponse getAdopterProfile(String userId) {
        try {
            AdopterProfile user = adopterProfileRepository.findByAdpIdNo(userId);
            return modelMapper.map(user, RetrieveUserResponse.class);

        } catch (Exception e ) {
            log.error(e.getMessage());
            return null;
        }
    }

    public List<RetrieveUserResponse> getAlladopterProfile() {
        try {
            List<AdopterProfile> adopterProfiles = adopterProfileRepository.findAllByOrderByUserName();
            List<RetrieveUserResponse> responses = new ArrayList<>();
            for (AdopterProfile adopterProfile : adopterProfiles) {
                responses.add(modelMapper.map(adopterProfile, RetrieveUserResponse.class));
            }

            return responses;

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public String updateAdopterProfile(String userId, AdopterRequest adopterRequest) {
        try {

            AdopterProfile user = adopterProfileRepository.findByAdpIdNo(userId);
            modelMapper.map(adopterRequest, user);
            adopterProfileRepository.save(user);
            return "success";

        } catch (Exception e) {
            log.error(e.getMessage());
            return "Fail to update user profile";
        }
    }

    public String deleteUser(String userId) {
        try {
            AdopterProfile user = adopterProfileRepository.findByAdpIdNo(userId);
            adopterProfileRepository.delete(user);
            return "User deleted successfully";

        } catch (Exception e) {
            log.error(e.getMessage());
            return "Fail to delete user profile";
        }
    }


}
