package com.example.petadoption.data.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdopterProfileRepository extends JpaRepository<AdopterProfile, Long> {

    AdopterProfile findByAdpIdNo(String nric);

    List<AdopterProfile> findAllByOrderByUserName();

}
