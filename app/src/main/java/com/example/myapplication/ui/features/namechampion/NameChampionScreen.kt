package com.example.myapplication.ui.features.namechampion

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.entities.Game
import com.example.myapplication.domain.models.ChampionCreationState
import com.example.myapplication.ui.components.RpgButton
import com.example.myapplication.ui.theme.*

@Composable
fun NameChampionScreen(
    onNavigateToModeSelectionScreen: () -> Unit
) {
    val viewModel = remember { NameChampionViewModel() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface)
                .border(2.dp, MaterialTheme.colorScheme.onSurface, RoundedCornerShape(8.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Name Your Champion",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = viewModel.championName,
                onValueChange = { viewModel.championName = it },
                label = {
                    Text("Enter a name", style = MaterialTheme.typography.bodyLarge)
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            )

            Spacer(modifier = Modifier.height(48.dp))

            RpgButton(
                text = "Continue",
                onClick = { viewModel.nameCharacterAndMoveNext(onNavigateToModeSelectionScreen) },
                enabled = viewModel.championName.isNotBlank()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NameChampionScreenPreview() {
    MyApplicationTheme {
        NameChampionScreen(onNavigateToModeSelectionScreen = {})
    }
}