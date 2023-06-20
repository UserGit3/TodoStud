@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.todostud.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SearchBar
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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.todostud.R
import com.example.todostud.data.NavigationItems


@Composable
fun navigationBar(navController: NavController) {
    val screenList = listOf(
        NavigationItems.MainScreen,
        NavigationItems.PomodoroScreen,
        NavigationItems.ProfileScreen,
        NavigationItems.SettingsScreen,
    )
    val iconElements = listOf(Icons.Default.Home, Icons.Default.Person, Icons.Default.Settings)
    var selectedItem by remember {
        mutableStateOf(0)
    }

    NavigationBar {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        screenList.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "Icon from bottom navigation"
                    )
                },
                label = { Text(stringResource(id = item.title)) },
                selected = currentRoute==item.route,
                onClick = { navController.navigate(item.route) }
            )
        }
    }
}

@Preview
@Composable
fun actionButton() {
    val listState = rememberLazyListState()
    val expandedFab by remember {
        derivedStateOf { listState.firstVisibleItemIndex == 0 }
    }
    ExtendedFloatingActionButton(
        onClick = { /*TODO*/ },
        expanded = expandedFab,
        icon = { Icon(Icons.Default.Add, "Add Icon") },
        text = { Text(stringResource(id = R.string.add_note)) },
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun topAppBar() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember {
        mutableListOf<String>()
    }
    SearchBar(
        modifier = Modifier
            .fillMaxWidth(),
        query = text,
        onQueryChange = { text = it },
        onSearch = {
            if (text.isNotEmpty()) {
                items.add(text)
                active = false
                text = ""
            } else {
                active = false
                text = ""
            }
        },
        active = active,
        onActiveChange = { active = it },
        placeholder = { Text(stringResource(id = R.string.search)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if (active) {
                Icon(
                    modifier = Modifier.clickable {
                        if (text.isNotEmpty()) {
                            text = ""
                        } else {
                            active = false
                        }
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon"
                )
            }
        }
    ) {
        if (items.isNotEmpty()) {
            items.forEach {
                Row(modifier = Modifier.padding(14.dp)) {
                    Icon(
                        modifier = Modifier.padding(end = 10.dp),
                        imageVector = Icons.Default.History,
                        contentDescription = "History ICon"
                    )
                    Text(text = it)
                }
            }
        }
    }
}
