package com.example.todostud.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todostud.R
import com.example.todostud.ui.components.SettingsItem

@Preview(showBackground = true)
@Composable
fun SettingsActivity() {
    Row(Modifier.padding(12.dp)) {
        Text(
            text = stringResource(id = R.string.navBar_settings),
            fontSize = MaterialTheme.typography.headlineLarge.fontSize
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SettingsItem()
        Text(
            text = "ToDo Stud App" + "\n" +
                    "Version 0.0.1",
            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle
        )
    }
}