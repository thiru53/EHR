package com.webApp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String name;

    @Nonnull
    private String contactDetails;

    @Nonnull
    private String address;

    @Nonnull
    private String email;

    @Nonnull
    private String gender;

    @Nonnull
    private String dob;

    @Nonnull
    private String medicalHistory;



    public Patient() {
    }

    public Patient(String name, String contactDetails, String address, String email, String gender, String dob, String medicalHistory) {
        this.name = name;
        this.contactDetails = contactDetails;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.medicalHistory = medicalHistory;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }



    // Additional constructors if needed
}
