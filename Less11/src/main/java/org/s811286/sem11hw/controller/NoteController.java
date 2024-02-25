package org.s811286.sem11hw.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.AllArgsConstructor;
import org.s811286.sem11hw.model.Note;
import org.s811286.sem11hw.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

    /**
     * Точка контроля: количество запросов
     */
    private final Counter requestCounter = Metrics.counter("number_of_requests");
    private final NoteService noteService;

    /**
     * Добавление заметки.
     * POST localhost:8080/notes
     * {
     * "header": "note1"
     * "content": "text1"
     * }
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    /**
     * Просмотр всех заметок.
     * GET localhost:8080/notes
     * Добавлено увеличение счетчика для точки контроля: количество запросов
     * requestCounter.increment()
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        requestCounter.increment();
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    /**
     * Получение заметки по ID.
     * GET localhost:8080/notes/1
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> noteById;
        try {
            noteById = noteService.getNoteById(id);
            Note note = noteById.get();
            return new ResponseEntity<>(note, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
    }

    /**
     * Редактирование заметки.
     * PUT localhost:8080/notes/1
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note existNote = noteService.getNoteById(id).orElse(null);
        if (existNote != null) {
            return new ResponseEntity<>(noteService.updateNote(id, note), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
    }

    /**
     * Удаление заметки.
     * DELETE localhost:8080/notes/1
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
