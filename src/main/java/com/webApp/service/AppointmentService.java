package com.webApp.service;

import com.webApp.entity.Appointment;
import com.webApp.repo.AppointmentRepository;
import com.webApp.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    public void scheduleAppointment(Appointment appointmentDetails) {
        Appointment appointment = appointmentRepository.findByAppointmentDateAndTimeSlot(appointmentDetails.getAppointmentDate(), appointmentDetails.getTimeSlot());
        if(Objects.nonNull(appointment)) {
            throw new RuntimeException("Please select a proper date and time");
        }
        appointmentRepository.save(appointmentDetails);
    }

    public List<String> getTotalTimeSlots() {
        List<String> timeSlots = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        for (int i = 0; i < 12; i++) {
            String  day = sdf.format(calendar.getTime());
            timeSlots.add(i, day.toUpperCase());
            calendar.add(Calendar.MINUTE, 15);
        }
        return timeSlots;
    }

    public void generateAvailableTimeSlots() {

    }

    public List<Appointment> getAppointmentsByPatientId(long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public Appointment getAppointmentById(long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    public void deleteAppointment() {
    }

    public Appointment rescheduleAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void getPatientIdByAppointmentId() {

    }

    public void sendReminder() {

    }
}
