package com.roaa.callforwarding.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacing(height: Dp = 16.dp) {
    Spacer(Modifier.height(height))
}

@Composable
fun HorizontalSpacing(width: Dp = 16.dp) {
    Spacer(Modifier.height(width))
}