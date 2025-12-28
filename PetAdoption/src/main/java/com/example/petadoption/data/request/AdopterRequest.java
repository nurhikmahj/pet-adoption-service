package com.example.petadoption.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdopterRequest {

    private String adpName;
    private String adpIdNo;
    private String adpAddress;
    private String adpContactNo;
    private Boolean petOwnerFlag;
    private String petId;

}
