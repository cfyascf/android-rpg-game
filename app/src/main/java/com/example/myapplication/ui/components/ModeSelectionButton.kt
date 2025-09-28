package com.example.myapplication.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.DarkBrownColor
import com.example.myapplication.ui.theme.GoldColor
import com.example.myapplication.ui.theme.ParchmentColor

@Composable
fun ModeSelectionButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val containerColor = if (isSelected) GoldColor else DarkBrownColor
    val contentColor = if (isSelected) ParchmentColor else ParchmentColor
    val border = if (isSelected) BorderStroke(2.dp, DarkBrownColor) else null

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        border = border
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
    }
}