package com.webApp.controller;

import com.webApp.repo.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final PatientRepository patientRepository;

    public RegistrationController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration-form";
    }

    @PostMapping
    public String registerPatient() {
        return "redirect:/patients";
    }

}
