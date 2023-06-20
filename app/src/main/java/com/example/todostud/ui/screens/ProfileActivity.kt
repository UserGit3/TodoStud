package com.example.todostud.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todostud.R


@Preview(showBackground = true)
@Composable
fun ProfileActivity() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            /*Icon(
                modifier = Modifier
                    .size(72.dp)
                    .padding(12.dp)
                    .clip(shape = CircleShape)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    ),
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Image"
            )*/
            Text(
                text = stringResource(id = R.string.navBar_profile),
                fontSize = MaterialTheme.typography.headlineLarge.fontSize
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(id = R.string.titlePerformance),
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(340.dp)
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(5))
                .clip(shape = RoundedCornerShape(5))

                .background(MaterialTheme.colorScheme.onPrimary)

        ) {

        }
    }
}

@Composable
fun weekStats() {

    val weekList = listOf("Mon", "Tue", "", "")
    Column() {
        Box(
            modifier = Modifier
                .height(12.dp)
                .background(Color.Gray)
        )
        Text(text = "Mon")
    }
}