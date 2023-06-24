@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.todostud.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todostud.R
import com.example.todostud.data.NavGraph
import com.example.todostud.data.NavigationItems
import com.example.todostud.presentation.add_edit_note.AddEditNoteScreen
import com.example.todostud.presentation.notes.NotesScreen
import com.example.todostud.presentation.util.Screen
import com.example.todostud.ui.components.navigationBar
import com.example.todostud.ui.components.topAppBar
import com.example.todostud.ui.theme.ToDoStudTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoStudTheme {
                // A surface container using the 'background' color from the theme
                val listState = rememberLazyListState()

                val navController = rememberNavController()

                val expandedFab by remember {
                    derivedStateOf { listState.firstVisibleItemIndex == 0 }
                }
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route


                Surface(color = MaterialTheme.colorScheme.primary) {
                    Scaffold(
                        topBar = {
                            if (currentRoute == NavigationItems.MainScreen.route || (currentRoute != null && currentRoute.startsWith(
                                    NavigationItems.NotesScreen.route
                                ))
                            )
                                topAppBar(navController)
                        },
                        floatingActionButton = {
                            if (currentRoute == NavigationItems.MainScreen.route) {
                                ExtendedFloatingActionButton(
                                    onClick = {
                                        navController.navigate(NavigationItems.AddEditNoteScreen.route)
                                    },
                                    expanded = expandedFab,
                                    icon = { Icon(Icons.Default.Add, "Add Icon") },
                                    text = { Text(stringResource(id = R.string.add_note)) },
                                )
                            }
                        },
                        bottomBar = { navigationBar(navController = navController) },
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(it)
                                .fillMaxSize()
                        ) {
                            NavGraph(navHostController = navController)
                        }
                    }
                }
            }
        }
    }
}