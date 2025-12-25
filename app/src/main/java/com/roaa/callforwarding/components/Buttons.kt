package com.roaa.callforwarding.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roaa.callforwarding.ui.theme.CallForwardingTheme

/**
 * Button Generic component.
 *
 * @param text  for text.
 * @param action for the action performed on button.
 * @param isPrimaryButton whether the button is primary or normal
 */
@Composable
fun CustomButtons(
    modifier: Modifier = Modifier,
    text: String,
    action: (() -> Unit),
    isPrimaryButton: Boolean = false
) {
    FilledTonalButton(
        onClick = { action() },
        modifier = modifier.fillMaxWidth().height(48.dp),
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = if (isPrimaryButton) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.surfaceContainerHighest
        )
    ) {
        Text(
            text = text,
            color = if (isPrimaryButton) MaterialTheme.colorScheme.onPrimary
            else MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CallForwardingTheme {
        CustomButtons(Modifier, "Android", {})
    }
}