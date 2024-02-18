package org.s811286.sem9hwMicroservice.service;

import lombok.AllArgsConstructor;
import org.s811286.sem9hwMicroservice.model.Note;
import org.s811286.sem9hwMicroservice.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    /**
     * Создание заметки.
     */
    public Note createNote(Note note) {
        note.setDateCreation(LocalDateTime.now());
        return repository.save(note);
    }

    /**
     * Просмотр всех заметок.
     */
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    /**
     * Получение заметки по ID.
     */
    public Optional<Note> getNoteById(Long id) {
        return repository.findById(id);
    }

    /**
     * Редактирование заметки.
     */
    public Note updateNote(Long id, Note noteChange) {
        Optional<Note> noteById = repository.findById(id);
        if (noteById.isPresent()) {
            Note note = noteById.get();
            note.setHeader(noteChange.getHeader());
            note.setContent(noteChange.getContent());
            if (noteChange.getDateCreation() != null) {
                note.setDateCreation(noteChange.getDateCreation());
            }
            return repository.save(note);
        } else {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
    }

    /**
     * Удаление заметки.
     */
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
