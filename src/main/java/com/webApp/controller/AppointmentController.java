package com.webApp.controller;

import com.webApp.entity.Appointment;
import com.webApp.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    // Other controller methods
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/schedule")
    public String showAppointmentForm(Model model) {
        return "appointmentForm";
    }

    @PostMapping("/schedule")
    public String processAppointmentForm(Appointment appointmentDetails, BindingResult bindingResult) {
        return "redirect:/patients";
    }

    @PostMapping("/reminders")
    public String sendAppointmentReminder() {
        return "message-page";
    }

}
