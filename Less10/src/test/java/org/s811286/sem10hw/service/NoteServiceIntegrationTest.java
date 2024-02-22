package org.s811286.sem10hw.service;

import org.junit.jupiter.api.Test;
import org.s811286.sem10hw.model.Note;
import org.s811286.sem10hw.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class NoteServiceIntegrationTest {
    @MockBean
    public NoteRepository repository;

    @Autowired
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
