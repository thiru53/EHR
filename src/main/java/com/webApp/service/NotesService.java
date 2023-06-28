package com.webApp.service;

import com.webApp.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
    private final NotesRepository noteRepository;
    @Autowired
    private PatientService patientService;

    @Autowired
    public NotesService(NotesRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void getNotesByPatientId() {

    }

    public void addNoteToPatient() {

    }
}
