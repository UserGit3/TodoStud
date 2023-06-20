package com.example.todostud.data


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timer
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.todostud.R


sealed class NavigationItems(val title: Int, val icon: ImageVector, val route: String) {
    object MainScreen : NavigationItems(R.string.navBar_home, Icons.Default.Home, "Main_Screen")
    object PomodoroScreen :
        NavigationItems(R.string.pomodoro_timer_name, Icons.Default.Timer, "Pomodoro_Screen")

    object ProfileScreen :
        NavigationItems(R.string.navBar_profile, Icons.Default.Person, "Profile_Screen")

    object SettingsScreen :
        NavigationItems(R.string.navBar_settings, Icons.Default.Settings, "Settings_Screen")

    object NotesScreen :
        NavigationItems(R.string.notes, Icons.Default.Note, "Notes_Screen")

    object AddEditNoteScreen :
        NavigationItems(
            R.string.notes,
            Icons.Default.Note,
            "Add_Edit_Note_Screen_Screen"
        )
}