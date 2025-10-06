package com.example.myapplication.ui.features.selectrace

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
import com.example.myapplication.domain.abstractions.RaceOptions
import com.example.myapplication.domain.entities.AttributeRollingModes
import com.example.myapplication.domain.models.ChampionCreationState
import com.example.myapplication.ui.components.ModeSelectionButton
import com.example.myapplication.ui.components.RpgButton
import com.example.myapplication.ui.theme.*

@Composable
fun SelectRaceScreen(
    onMoveToSelectArchetypeScreen: () -> Unit) {
    val viewModel = remember { SelectRaceViewModel() }

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
                text = "Select your race",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                RaceOptions.entries.forEach { race ->
                    ModeSelectionButton(
                        text = race.toString(),
                        isSelected = viewModel.selectedRace == race,
                        onClick = { viewModel.selectedRace = race }
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            RpgButton(
                text = "Next...",
                onClick = { viewModel.selectRaceAndMoveNext(viewModel.selectedRace, onMoveToSelectArchetypeScreen) },
                enabled = viewModel.selectedRace != null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectRaceScreenPreview() {
    MyApplicationTheme {
        SelectRaceScreen(onMoveToSelectArchetypeScreen = {})
    }
}