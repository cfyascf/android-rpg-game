// Em ui/screens/SelectAttributeRollingModeScreen.kt

package com.example.myapplication.ui.features.selectattributerollingmode

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.entities.AttributeRollingModes
import com.example.myapplication.domain.models.ChampionCreationState
import com.example.myapplication.ui.components.ModeSelectionButton
import com.example.myapplication.ui.components.RpgButton
import com.example.myapplication.ui.theme.*

@Composable
fun SelectAttributeRollingModeScreen(
    onMoveToModeSelectedScreen: (selectedMode: AttributeRollingModes) -> Unit) {
    val viewModel = remember { SelectAttributeRollingModeViewModel() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(8.dp))
                .background(ParchmentColor)
                .border(2.dp, DarkBrownColor, RoundedCornerShape(8.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Select your preferred mode",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AttributeRollingModes.entries.forEach { mode ->
                    ModeSelectionButton(
                        text = mode.toString(),
                        isSelected = viewModel.selectedMode == mode,
                        onClick = { viewModel.selectedMode = mode }
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            RpgButton(
                text = "Start picking your attributes...",
                onClick = { viewModel.selectModeAndMoveNext(viewModel.selectedMode, onMoveToModeSelectedScreen) },
                enabled = viewModel.selectedMode != null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectAttributeRollingModeScreenPreview() {
    MyApplicationTheme {
        SelectAttributeRollingModeScreen(onMoveToModeSelectedScreen = {})
    }
}