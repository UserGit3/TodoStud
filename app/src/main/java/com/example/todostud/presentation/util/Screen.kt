package com.example.todostud.presentation.util

sealed class Screen(val route: String){
    object NotesScreen: Screen("Notes_Screen")
    object AddEditNoteScreen: Screen("Add_Edit_Note_Screen_Screen")
}
