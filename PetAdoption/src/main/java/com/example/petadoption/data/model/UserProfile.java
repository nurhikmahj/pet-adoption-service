package com.example.petadoption.data.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user_profile")
public class UserProfile {

    @Column(name = "user_profile_id")
    @Id
    private String userProfileId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_nric")
    private String userNric;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "pet_owner_flag")
    private Boolean petOwnerFlag;

    @Column(name = "pet_id")
    private String petId;
}
