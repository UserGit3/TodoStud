package com.example.todostud.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.todostud.R
import com.example.todostud.data.NavGraph
import com.example.todostud.presentation.notes.NotesScreen
import com.example.todostud.ui.components.navigationBar
import com.example.todostud.ui.components.noteCard
import com.example.todostud.ui.components.topAppBar

@Composable
fun MainScreen() {
    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
        noteCard()
    }
}