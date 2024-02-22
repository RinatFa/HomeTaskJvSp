package org.s811286.sem10hw.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.s811286.sem10hw.model.Note;
import org.s811286.sem10hw.repository.NoteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class NoteServiceSimpleTest {
    @Mock
    public NoteRepository repository;

    @InjectMocks
    public NoteService noteService;

    @Test
    void createNote() {
        /**
         * Блок подготовки данных
         */
        Note note = new Note();
        note.setId(1L);
        note.setHeader("note1");
        note.setContent("text1");
        given(repository.save(note)).willReturn(note);
        /**
         * Блок выполнения
         */
        String sHeader = noteService.createNote(note).getHeader();
        /**
         * Блок утверждений
         */
        assertEquals("note1", sHeader);
    }
}
