package com.webApp.service;

import com.webApp.entity.Note;
import com.webApp.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    private final NotesRepository noteRepository;
    @Autowired
    private PatientService patientService;

    @Autowired
    public NotesService(NotesRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getNotesByPatientId(long patientId) {
        return noteRepository.findByPatientId(patientId);
    }

    public void addNoteToPatient(Note note) {
        noteRepository.save(note);
    }
}
