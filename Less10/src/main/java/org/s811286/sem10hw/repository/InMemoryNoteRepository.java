package org.s811286.sem10hw.repository;

import org.s811286.sem10hw.model.Note;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryNoteRepository {
    private List<Note> notes;

    public InMemoryNoteRepository() {
        this.notes = new ArrayList<>();
        notes.add(new Note(1L, "note1", "text1", LocalDateTime.now()));
        notes.add(new Note(2L, "note2", "text2", LocalDateTime.now()));
    }

    public Note findById(Long id) {
        return notes.get(Math.toIntExact(id));
    }

    public List<Note> findAll() {
        return new ArrayList<>(notes);
    }
}
