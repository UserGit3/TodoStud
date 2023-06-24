package com.example.todostud.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PauseCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todostud.R
import com.example.todostud.ui.components.PomodoroTimer

@Preview
@Composable
fun PomodoroScreen() {
    var min = 25
    var sec = 0
    var sec2 = 0
    Text(
        modifier = Modifier.padding(12.dp),
        text = stringResource(id = R.string.pomodoro_timer_name),
        fontSize = MaterialTheme.typography.headlineLarge.fontSize
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /*Box() {
            Text(text = "$min:$sec$sec2", fontSize = 72.sp)
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Row() {
            var timerStarted by remember { mutableStateOf(false) }
//            var iconButton by remember { mutableStateOf(Icons.Default.PlayArrow) }
            Button(
                onClick = {
                    timerStarted = !timerStarted
                },
            ) {
                Icon(
                    imageVector = if (timerStarted) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = "Start timer"
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Button(onClick = { *//*TODO*//* }) {
                Icon(imageVector = Icons.Default.Stop, contentDescription = "Start timer")
            }
        }*/

        PomodoroTimer(
            totalTime = 25 * 60L * 1000L,
            handleColor = Color.Green,
            inActiveBar = Color.DarkGray,
            activeBar = Color.Blue,
            modifier = Modifier.size(200.dp)
        )
    }
}

fun PomodoroTimerWork(min: Int, sec: Int) {

}