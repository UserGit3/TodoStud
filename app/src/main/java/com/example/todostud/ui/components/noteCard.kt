package com.example.todostud.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todostud.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun noteCard(
    headerText: String = "",
    bodyText: String = ""
):Unit {
    var textHeaderFiledState by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(
            TextFieldValue()
        )
    }
    var textBodyFiledState by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(
            TextFieldValue()
        )
    }
    var textFiledBsic by remember {
        mutableStateOf("")
    }
    var textList = String

    val placeHolderHeader = ""

    var expendedState by remember {
        mutableStateOf(false)
    }

    val rotationState by animateFloatAsState(targetValue = if (expendedState) 180f else 0f)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        elevation = CardDefaults.cardElevation(),
        shape = MaterialTheme.shapes.medium,
        onClick = {
            expendedState = !expendedState
        }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
/*            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = textHeaderFiledState,
                onValueChange = { newText -> textHeaderFiledState = newText },
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                ),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),

                )

            Spacer(modifier = Modifier.height(15.dp))*/
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    modifier = Modifier.weight(6f),
                    value = textHeaderFiledState,
                    placeholder = {
                        Text(
                            stringResource(id = R.string.placeholder_title_note),
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    onValueChange = {
                        textHeaderFiledState = it
                    },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                )
                IconButton(
                    modifier = Modifier
                        .alpha(0.4f)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expendedState = !expendedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }
            }
            if (expendedState) {
                Divider(
                    Modifier.padding(horizontal = 5.dp),
                    color = DividerDefaults.color
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text(
                            stringResource(id = R.string.placeholder_body_note),
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        )
                    },
                    value = textBodyFiledState,
                    onValueChange = { textBodyFiledState = it },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
            }
        }

        Divider(
            Modifier
                .padding(start = 5.dp, end = 5.dp),

            )
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AssistChip(
                onClick = {
                },
                label = { Text(text = "Text") },
                leadingIcon = { },
            )
            datePicker()
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Done")
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
noteCard(headerText = "Small Text", bodyText = "Body Text")
}