package com.example.petadoption.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_adopter_profile")
public class AdopterProfile {


    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "adp_name")
    private String adpName;

    @Column(name = "adp_id_no")
    private String adpIdNo;

    @Column(name = "adp_address")
    private String adpAddress;

    @Column(name = "adp_contact")
    private String adpContact;

    @Column(name = "pet_owner_flag")
    private Boolean petOwnerFlag;

    @Column(name = "pet_id")
    private String petId;
}
