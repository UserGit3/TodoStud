@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.todostud.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun SettingsItem() {
    var onConfirm = false
    var onDismiss = false
    Column(modifier = Modifier.padding(8.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = CardDefaults.shape)
                .background(
                    Color(MaterialTheme.colorScheme.primary.value)
                )
                .shadow(elevation = 8.dp)


        ) {
            Text(modifier = Modifier.padding(6.dp), text = "Teacher List")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(),
            onClick = { }
        ) {
            Text(
                modifier = Modifier.padding(6.dp),
                text = "Teacher List",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            elevation = CardDefaults.cardElevation(),
            onClick = { Unit }
        ) {
            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.padding(6.dp),
                    text = "Предметы",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }

        }
    }
}

@Composable
fun TeacherListAlertDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(onDismissRequest = { /*TODO*/ }) {
        Card(modifier = Modifier.fillMaxWidth(0.95f)) {
            Text(text = "Simple Text")
        }
    }
}