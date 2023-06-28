package com.webApp.controller;

import com.webApp.entity.Patient;
import com.webApp.repo.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final PatientRepository patientRepository;

    public RegistrationController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public String showRegistrationForm(Patient patient) {
        return "registration-form";
    }

    @PostMapping
    public String registerPatient(Model model, RedirectAttributes redirAttrs, Patient patient, BindingResult bindingResult) {

        if(patientRepository.existsByContactDetails(patient.getContactDetails())) {
            redirAttrs.addFlashAttribute("error", "Contact details ("+patient.getContactDetails()+") already registered");
            return "redirect:/registration";
        }
        redirAttrs.addFlashAttribute("success", "Registered Successfully");
        patientRepository.save(patient);
        return "redirect:/patients";
    }

}
