package com.example.todostud.data

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todostud.presentation.add_edit_note.AddEditNoteScreen
import com.example.todostud.presentation.notes.NotesScreen
import com.example.todostud.presentation.util.Screen
import com.example.todostud.ui.screens.MainScreen
import com.example.todostud.ui.screens.PomodoroScreen
import com.example.todostud.ui.screens.ProfileActivity
import com.example.todostud.ui.screens.SettingsActivity

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "Main_Screen") {
        composable(
            "Notes_Screen" + "?searchBarContent={searchBarContent}", arguments = listOf(
                navArgument(
                    name = "searchBarContent"
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val search = it.arguments?.getString("searchBarContent") ?: ""
            NotesScreen(navHostController, searchBarContent = search)
        }
        composable("Main_Screen"){
            NotesScreen(navController = navHostController)
        }
        composable("Pomodoro_Screen") {
            PomodoroScreen()
        }
        composable("Profile_Screen") {
            ProfileActivity()
        }
        composable("Settings_Screen") {
            SettingsActivity()
        }
        composable("Notes_Screen") {
            NotesScreen(navHostController)
        }
        composable("Add_Edit_Note_Screen_Screen" +
                "?noteId={noteId}&noteColor={noteColor}", arguments = listOf(
            navArgument(
                name = "noteId"
            ) {
                type = NavType.IntType
                defaultValue = -1
            },
            navArgument(
                name = "noteColor"
            ) {
                type = NavType.IntType
                defaultValue = -1
            }
        )
        ) {
            val color = it.arguments?.getInt("noteColor") ?: -1
            AddEditNoteScreen(navController = navHostController, noteColor = color)
        }
    }
}