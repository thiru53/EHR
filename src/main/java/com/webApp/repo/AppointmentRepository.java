package com.webApp.repo;

import com.webApp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDate(LocalDate appointmentdate);
    Appointment findByAppointmentDateAndTimeSlot(LocalDate appointmentDate, String timeSlot);
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByAppointmentDateAfter(Date currentDate);
}