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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String searchPatients(String name,@ModelAttribute("successMsg") String successMsg, Model model) {
        List<Patient> patients =  patientService.searchPatients(name);
        model.addAttribute("name", name);
        model.addAttribute("patients", patients);
        return "patient-search";
    }

    @GetMapping("/{id}")
    public String getPatientDetails(@PathVariable("id") long patientId, @ModelAttribute("successMsg") String successMsg, Model model) {
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
    public String updatePatient(@PathVariable("id") long patientId, Patient patient, BindingResult bindingResult, RedirectAttributes redirAttrs, Model model) {
        if(bindingResult.hasErrors()){
            patient.setId(patientId);
            return "edit-patient";
        }
        try{
            patientService.updatePatient(patient);
        } catch(Exception ex){
            model.addAttribute("error", ex.getMessage());
            return "edit-patient";
        }
        redirAttrs.addFlashAttribute("successMsg", "Patient updated Successfully");
        return "redirect:/patients/{id}";
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
            model.addAttribute("error", "No appointments available");
        }
        model.addAttribute("appointmentDate", appointment.getAppointmentDate());
        model.addAttribute("scheduledTimeSlot", appointment.getTimeSlot());
        model.addAttribute("timeSlots", appointmentService.getTotalTimeSlots());
        return "rescheduleForm";
    }

    @PostMapping("/appointment/reschedule/{appointmentId}")
    public String rescheduleAppointment(@PathVariable("appointmentId") long appointmentId, LocalDate appointmentDate, String timeSlot, RedirectAttributes redirAttrs) {
        try {
            Appointment appointment = appointmentService.getAppointmentById(appointmentId);
            appointment.setAppointmentDate(appointmentDate);
            appointment.setTimeSlot(timeSlot);
            Appointment updateAppointment = appointmentService.rescheduleAppointment(appointment);
        } catch (Exception ex){
            redirAttrs.addFlashAttribute("error","Reschedule not done, please try again");
        }

        return "redirect:/patients/appointment/reschedule/"+appointmentId;
    }

    @GetMapping("/appointment/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable("appointmentId") long appointmentId) {
        long patientId = appointmentService.getPatientIdByAppointmentId(appointmentId);
        appointmentService.deleteAppointment(appointmentId);
        return "redirect:/patients/"+patientId;
    }

}
