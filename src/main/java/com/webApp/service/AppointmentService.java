package com.webApp.service;

import com.webApp.entity.Appointment;
import com.webApp.repo.AppointmentRepository;
import com.webApp.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    private void getTotalTimeSlots() {

    }

    public void generateAvailableTimeSlots() {

    }

    public List<Appointment> getAppointmentsByPatientId(long patientId) {
        return appointmentRepository.findByPatientId(patientId);
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
