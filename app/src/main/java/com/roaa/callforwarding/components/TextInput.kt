package com.roaa.callforwarding.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

/**
 * Number input text field.
 *
 * @param textFieldValue - text field value.
 * @param textFieldValueSetter call to set the text field value
 */
@Composable
fun NumberInput(
    modifier: Modifier = Modifier,
    textFieldValue: TextFieldValue,
    textFieldValueSetter: (TextFieldValue) -> Unit
) {
    TextField(
        value = textFieldValue,
        onValueChange = { newText ->
            textFieldValueSetter(newText)
        },
        singleLine = true,
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp),
        placeholder = {
            Text(
                "Phone Number",
                style = typography.bodyLarge,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant.copy(
                        0.38f,
                    ),
            )
        },
        shape = RoundedCornerShape(20.dp),
        colors =
            TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}