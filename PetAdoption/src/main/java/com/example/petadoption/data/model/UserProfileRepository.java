package com.example.petadoption.data.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findByUserNric(String nric);

    List<UserProfile> findAllByOrderByUserName();

}
