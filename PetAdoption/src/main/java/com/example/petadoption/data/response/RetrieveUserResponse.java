package com.example.petadoption.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrieveUserResponse {

    private String userName;
    private String userId;
    private String userAddress;
    private Boolean petOwnerFlag;
    private String petId;

}
