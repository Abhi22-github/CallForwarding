package com.roaa.callforwarding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.roaa.callforwarding.ui.theme.CallForwardingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CallForwardingTheme {
                var numberInput by remember { mutableStateOf(TextFieldValue("")) }
                val context = LocalContext.current
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TextField(
                                value = numberInput,
                                onValueChange = { newText ->
                                    numberInput = newText
                                },
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(0.dp, 4.dp),
                                placeholder = {
                                    Text(
                                        "Phone Number",
                                        style = typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                                            0.38f
                                        )
                                    )
                                },
                                shape = RoundedCornerShape(20.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                                    focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            )
                            Spacer(Modifier.height(16.dp))
                            CustomButtons(text = "Activate", action = {

                                val intent = Intent(Intent.ACTION_DIAL).apply {
                                    data = "tel:${Uri.encode(numberInput.text)}".toUri()
                                }
                                context.startActivity(intent)
                            })
                            CustomButtons(text = "De-Activate", action = {
                                val intent = Intent(Intent.ACTION_DIAL).apply {
                                    data = "tel:${Uri.encode(numberInput.text)}".toUri()
                                }
                                context.startActivity(intent)
                            })
                            CustomButtons(text = "Current Status", action = {
                                val intent = Intent(Intent.ACTION_DIAL).apply {
                                    data = "tel:${Uri.encode(numberInput.text)}".toUri()
                                }
                                context.startActivity(intent)
                            })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomButtons(modifier: Modifier = Modifier, text: String, action: (() -> Unit)) {
    FilledTonalButton(onClick = { action }, modifier = modifier.fillMaxWidth()) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CallForwardingTheme {
        CustomButtons(Modifier, "Android", {})
    }
}