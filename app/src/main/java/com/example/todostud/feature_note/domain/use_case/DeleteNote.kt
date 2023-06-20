package com.example.todostud.feature_note.domain.use_case

import com.example.todostud.feature_note.domain.model.Note
import com.example.todostud.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repositiory: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repositiory.deleteNote(note)
    }
}