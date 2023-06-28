package com.webApp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointmentDetails")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id")
    private Long patientId;

    private String name;
    private int age;

    @Column(name = "appointmentDate")
    private LocalDate appointmentDate;

    @Column(name = "time_slot")
    private String timeSlot;

    private String purpose;

    @Column(name = "doctor_name")
    private String doctorName;
    private String email;


    // Constructors, getters, and setters

    public Appointment() {
    }

    public Appointment(Long patientId, String name, int age, LocalDate appointmentDate, String timeSlot, String purpose, String doctorName, String email) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.purpose = purpose;
        this.doctorName = doctorName;
        this.email=email;

    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
