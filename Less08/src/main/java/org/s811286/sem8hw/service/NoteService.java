package org.s811286.sem8hw.service;

import lombok.AllArgsConstructor;
import org.s811286.sem8hw.aspects.TrackUserAction;
import org.s811286.sem8hw.model.Note;
import org.s811286.sem8hw.repository.NoteRepository;
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
     * { "id": 2,
     * "header": "note5",
     * "content": "text2345" }
     * User called method createNote with parameters
     * [Note(id=2, header=note5, content=text2345, dateCreation=null)] will execute
     * <p>
     * { "header": "note3",
     * "content": "text3" }
     * User called method createNote with parameters
     * [Note(id=null, header=note3, content=text3, dateCreation=null)] will execute
     */
    @TrackUserAction
    public Note createNote(Note note) {
        note.setDateCreation(LocalDateTime.now());
        return repository.save(note);
    }

    /**
     * Просмотр всех заметок.
     * User called method getAllNotes with parameters [] will execute
     * Method has completed its work
     */
    @TrackUserAction
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    /**
     * Получение заметки по ID.
     * User called method getNoteById with parameters [3] will execute
     * { "id": 3,
     * "header": "note3",
     * "content": "text3",
     * "dateCreation": "2024-02-15T23:06:33.7263013" }
     */
    @TrackUserAction
    public Optional<Note> getNoteById(Long id) {
        return repository.findById(id);
    }

    /**
     * Редактирование заметки.
     * User called method updateNote with parameters
     * [3, Note(id=null, header=note35, content=text35, dateCreation=null)] will execute
     * { "header": "note35",
     * "content": "text35" }
     * <p>
     * User called method getNoteById with parameters [3] will execute
     * { "id": 3,
     * "header": "note35",
     * "content": "text35",
     * "dateCreation": "2024-02-15T23:06:33.726301" }
     */
    @TrackUserAction
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
     * User called method deleteNote with parameters [1] will execute
     * Method has completed its work
     */
    @TrackUserAction
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
