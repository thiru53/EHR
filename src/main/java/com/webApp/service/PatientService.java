package com.webApp.service;

import com.webApp.entity.Patient;
import com.webApp.repo.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> searchPatients(String name) {
        return (Objects.nonNull(name) && !name.isEmpty()) ? patientRepository.findByNameContainingIgnoreCase(name) : patientRepository.findAll();
    }

    public Patient getPatientById(long patientId) {
        return patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient doesn't exists for id :"+patientId));
    }

    public void getMedicalHistoryForPatient() {

    }

    public void updatePatient() {

    }
}