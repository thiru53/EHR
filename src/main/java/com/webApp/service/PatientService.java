package com.webApp.service;

import com.webApp.entity.Patient;
import com.webApp.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> searchPatients() {
       return patientRepository.findAll();

    }

    public Optional<Patient> getPatientByName(String name) {
        return patientRepository.findByName(name);
    }
    public void getPatientById() {

    }

    public void getMedicalHistoryForPatient() {

    }

    public void updatePatient() {

    }
}