package com.webApp.service;

import com.webApp.entity.Appointment;
import com.webApp.repo.AppointmentRepository;
import com.webApp.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        appointmentRepository.save(appointmentDetails);
    }

    private void getTotalTimeSlots() {

    }

    public void generateAvailableTimeSlots() {

    }

    public void getAppointmentsByPatientId() {

    }

    public void getAppointmentById() {

    }

    public void deleteAppointment() {
    }

    public void rescheduleAppointment() {
    }

    public void getPatientIdByAppointmentId() {

    }

    public void sendReminder() {

    }
}
