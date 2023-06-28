package com.webApp.controller;

import com.webApp.entity.Patient;
import com.webApp.service.AppointmentService;
import com.webApp.service.NotesService;
import com.webApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private NotesService notesService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public String searchPatients(Model model, String name) {
        List<Patient> patients = patients =  patientService.searchPatients(name);
        model.addAttribute("name", name);
        model.addAttribute("patients", patients);
        return "patient-search";
    }

    @GetMapping("/{id}")
    public String getPatientDetails(Model model, @PathVariable("id") long patientId) {
        Patient patient = patient = patientService.getPatientById(patientId);
        model.addAttribute("patient", patient);
        return "patient-details";
    }

    @GetMapping("/edit/{id}")
    public String editPatient() {
        return "edit-patient";
    }

    @PostMapping("/update/{id}")
    public String updatePatient() {
        return "redirect:/patients/<id>";
    }

    @GetMapping("notes/view/{id}")
    public String viewNotes() {
        return "notes-page";
    }

    @GetMapping("notes/add/{id}")
    public String showAddNoteForm() {
        return "add-note";
    }

    @PostMapping("notes/add/{id}")
    public String addNote() {
        return "redirect:/patients/notes/view/<patientId>";
    }

    @GetMapping("/appointments/{patientId}")
    public String viewAppointments() {
        return "appointmentList";
    }

    @GetMapping("/appointment/reschedule/{appointmentId}")
    public String showRescheduleForm() {
        return "rescheduleForm";
    }

    @PostMapping("/appointment/reschedule/{appointmentId}")
    public String rescheduleAppointment() {
        return "redirect:/patients/appointment/reschedule/<appointmentId>";
    }

    @PostMapping("/appointment/delete")
    public String deleteAppointment() {
        return "redirect:/patients/<patientId>";
    }

}
