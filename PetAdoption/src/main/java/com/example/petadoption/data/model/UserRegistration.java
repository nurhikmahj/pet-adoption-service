package com.example.petadoption.data.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user_registration")
public class UserRegistration {

    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_emp_id")
    private String userEmpId;

    @Column(name = "user_contact")
    private String userContact;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_id_no")
    private String userIdNo;

    @Column(name = "is_admin_flag")
    private Boolean isAdminFlag;

}
