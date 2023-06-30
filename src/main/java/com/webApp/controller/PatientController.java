package com.webApp.controller;

import com.webApp.entity.Appointment;
import com.webApp.entity.Note;
import com.webApp.entity.Patient;
import com.webApp.service.AppointmentService;
import com.webApp.service.NotesService;
import com.webApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private NotesService notesService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(value = {"", "/"})
    public String searchPatients(Model model, String name) {
        List<Patient> patients =  patientService.searchPatients(name);
        model.addAttribute("name", name);
        model.addAttribute("patients", patients);
        return "patient-search";
    }

    @GetMapping("/{id}")
    public String getPatientDetails(Model model, @PathVariable("id") long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        model.addAttribute("patient", patient);
        return "patient-details";
    }

    @GetMapping("/edit/{id}")
    public String editPatient(Model model, @PathVariable("id") long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        model.addAttribute("patient", patient);
        return "edit-patient";
    }

    @PostMapping("/update/{id}")
    public String updatePatient(@PathVariable("id") long patientId, Patient patient, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            patient.setId(patientId);
            return "edit-patient";
        }
        patientService.updatePatient(patient);
        return "redirect:/patients/"+patient.getId();
    }

    @GetMapping("notes/view/{id}")
    public String viewNotes(@PathVariable("id") long patientId, Model model) {
        List<Note> notes = notesService.getNotesByPatientId(patientId);
        model.addAttribute("notes", notes);
        model.addAttribute("patientId",patientId);
        return "notes-page";
    }

    @GetMapping("notes/add/{id}")
    public String showAddNoteForm(@PathVariable("id") long patientId, Model model) {
        Patient patient = patientService.getPatientById(patientId);
        model.addAttribute("patient", patient);
        return "add-note";
    }

    @PostMapping("notes/add/{id}")
    public String addNote(@PathVariable("id") long patientId, String content) {
        Patient patient = patientService.getPatientById(patientId);
        Note note = new Note();
        note.setContent(content);
        note.setPatient(patient);
        notesService.addNoteToPatient(note);
        return "redirect:/patients/notes/view/"+patientId;
    }

    @GetMapping("/appointments/{patientId}")
    public String viewAppointments(@PathVariable("patientId") long patientId, Model model) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);
        model.addAttribute("appointments", appointments);
        return "appointmentList";
    }

    @GetMapping("/appointment/reschedule/{appointmentId}")
    public String showRescheduleForm(@PathVariable("appointmentId") long appointmentId, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if(Objects.isNull(appointment)) {
            model.addAttribute("error", "No appointment slots available");
        }
        model.addAttribute("appointmentDate", appointment.getAppointmentDate());
        model.addAttribute("timeSlots", appointmentService.getTotalTimeSlots());
        return "rescheduleForm";
    }

    @PostMapping("/appointment/reschedule/{appointmentId}")
    public String rescheduleAppointment(@PathVariable("appointmentId") long appointmentId, LocalDate appointmentDate, String timeSlot) {

        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setTimeSlot(timeSlot);

        Appointment updateAppointment = appointmentService.rescheduleAppointment(appointment);


        return "redirect:/patients/appointment/reschedule/"+appointmentId;
    }

    @PostMapping("/appointment/delete")
    public String deleteAppointment() {
        return "redirect:/patients/<patientId>";
    }

}
