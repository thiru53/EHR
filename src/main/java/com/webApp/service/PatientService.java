package com.webApp.service;

import com.webApp.entity.Patient;
import com.webApp.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> searchPatients(String name) {
        return (Objects.nonNull(name) && !name.isEmpty()) ? patientRepository.findByNameContainingIgnoreCase(name) : List.of();
    }

    public Patient getPatientById(long patientId) {
        return patientRepository.findById(patientId).orElse(new Patient());
    }

    public void getMedicalHistoryForPatient() {

    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }
}