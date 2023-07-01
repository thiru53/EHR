package com.webApp.controller;

import com.webApp.entity.Patient;
import com.webApp.repo.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "registration-form";
    }

    @PostMapping
    public String registerPatient(@ModelAttribute("patient") Patient patient, Model model) {
        // validate
        if(patientRepository.existsByContactDetails(patient.getContactDetails())) {
            model.addAttribute("error", "Contact details already registered");
            return "registration-form";
        }
        patientRepository.save(patient);
        return "redirect:/patients";
    }

}
