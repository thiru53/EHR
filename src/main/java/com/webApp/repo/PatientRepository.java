package com.webApp.repo;

import com.webApp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//PatientRepository.java
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCase(String name);

    boolean existsById(Long patientId);

    Optional<Patient> findByName(String patientName);
    Optional<Patient> findByIdAndName(Long patientId, String patientName);

    boolean existsByContactDetails(String contactDetails);
}
