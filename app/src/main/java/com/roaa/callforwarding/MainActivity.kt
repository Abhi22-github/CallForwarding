package com.roaa.callforwarding

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.roaa.callforwarding.components.CustomButtons
import com.roaa.callforwarding.components.NumberInput
import com.roaa.callforwarding.components.VerticalSpacing
import com.roaa.callforwarding.ui.theme.CallForwardingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CallForwardingTheme {

                val activateString = getString(R.string.activate)
                val deactivateString = getString(R.string.deactivate)
                val statusString = getString(R.string.status)
                val callForwardingString = getString(R.string.call_forwarding)
                val manageCallsString = getString(R.string.manage_incoming_calls)
                var numberInput by remember { mutableStateOf(TextFieldValue("")) }
                val context = LocalContext.current

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = callForwardingString,
                                style = typography.titleLarge,
                                fontWeight = FontWeight(600),
                            )
                            Text(
                                text = manageCallsString,
                                style = typography.bodyMedium,
                            )
                            VerticalSpacing(48.dp)

                            NumberInput(textFieldValue = numberInput) { numberInput = it }
                            VerticalSpacing(24.dp)
                            CustomButtons(
                                text = activateString,
                                action = { context.sendIntent("tel:${Uri.encode("*21*${numberInput.text}#")}".toUri()) },
                                isPrimaryButton = true
                            )
                            VerticalSpacing(12.dp)
                            CustomButtons(
                                text = deactivateString,
                                action = { context.sendIntent("tel:${Uri.encode("#21#")}".toUri()) })
                            VerticalSpacing(12.dp)
                            CustomButtons(
                                text = statusString,
                                action = { context.sendIntent("tel:${Uri.encode("*#21#")}".toUri()) })
                        }
                    }

                }
            }
        }
    }
}

fun Context.sendIntent(dataUri: Uri) {
    val intent = Intent(Intent.ACTION_DIAL).apply { data = dataUri }
    this.startActivity(intent)
}
