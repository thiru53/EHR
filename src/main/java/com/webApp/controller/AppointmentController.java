package com.webApp.controller;

import com.webApp.entity.Appointment;
import com.webApp.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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
        List<String> timeSlot = getTimeSet(true);
        model.addAttribute("timeSlots", timeSlot);
        return "appointmentForm";
    }

    @PostMapping("/schedule")
    public String processAppointmentForm(Appointment appointmentDetails, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        try {
            appointmentService.scheduleAppointment(appointmentDetails);
        } catch (Exception ex){
            redirAttrs.addFlashAttribute("error",ex.getMessage());
            return "redirect:/appointments/schedule";
        }
        return "redirect:/patients";
    }

    @PostMapping("/reminders")
    public String sendAppointmentReminder() {
        return "message-page";
    }

    private List<String> getTimeSet(boolean isCurrentDay) {
        List<String> results = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);// what should be the default?
        if(!isCurrentDay){
            calendar.set(Calendar.HOUR_OF_DAY, 9);
        }
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        for (int i = 0; i < 9; i++) {
            String  day1 = sdf.format(calendar.getTime());
            results.add(i, day1.toUpperCase());
            // add 15 minutes to the current time; the hour adjusts automatically!
            calendar.add(Calendar.MINUTE, 15);
        }
        return results;
    }
}
