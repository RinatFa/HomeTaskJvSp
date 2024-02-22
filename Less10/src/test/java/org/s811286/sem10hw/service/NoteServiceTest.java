package org.s811286.sem10hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.s811286.sem10hw.model.Note;
import org.s811286.sem10hw.repository.InMemoryNoteRepository;
import org.s811286.sem10hw.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NoteServiceTest {
    InMemoryNoteRepository fakeRepo;
    Note fakefindById1;
    String fakeTitle1;
    List<Note> fakeList;
    NoteRepository noteRepositoryMock;
    NoteService noteService;

    /**
     * Блок подготовки данных
     */
    @BeforeEach
    void setUp() {
        fakeRepo = new InMemoryNoteRepository();
        fakefindById1 = fakeRepo.findById(1L);
        fakeTitle1 = fakefindById1.getHeader();
        fakeList = fakeRepo.findAll();
        noteRepositoryMock = mock(NoteRepository.class);
        noteService = new NoteService(noteRepositoryMock);
    }

    @Test
    void findNoteByIdTest() {
        /**
         * Блок подготовки данных
         */
        when(noteRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(fakefindById1));
        /**
         * Блок выполнения
         */
        Note note = noteService.getNoteById(1L).get();
        String sTitle = note.getHeader();
        /**
         * Блок утверждений
         */
        assertEquals(fakeTitle1, sTitle);
        verify(noteRepositoryMock, times(1)).findById(1L);
    }

    @Test
    void findAllNotesTest() {
        /**
         * Блок подготовки данных
         */
        when(noteRepositoryMock.findAll()).thenReturn(fakeList);
        /**
         * Блок выполнения
         */
        List<Note> listNote = noteService.getAllNotes();
        /**
         * Блок утверждений
         */
        assertEquals(fakeList, listNote);
        verify(noteRepositoryMock, times(1)).findAll();
    }
}
