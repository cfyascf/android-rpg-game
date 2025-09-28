package com.example.myapplication.ui.features.heroicattributerolling

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.components.RpgButton
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun HeroicAttributeRollingScreen(
    onNavigateToRaceSelectionScreen: () -> Unit,
    viewModel: HeroicAttributeRollingViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface)
                .border(2.dp, MaterialTheme.colorScheme.onSurface, RoundedCornerShape(8.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Character Sheet",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Heroic Mode",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )

            RpgButton(
                onClick = { viewModel.rollDices() },
                text = "Roll the dices",
                modifier = Modifier.padding(top = 16.dp)
            )

            if (uiState.rolledScores.isNotEmpty()) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = if (uiState.selectedScore == null) "Select a score" else "Select an attribute",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    uiState.unassignedScores.forEach { score ->
                        ScoreChip(
                            score = score,
                            isSelected = score == uiState.selectedScore,
                            onClick = { viewModel.selectScore(score) }
                        )
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                AssignableAttributeEditor(name = "Strength", value = uiState.strength, onClick = { viewModel.assignScoreToAttribute("Strength") })
                AssignableAttributeEditor(name = "Dexterity", value = uiState.dexterity, onClick = { viewModel.assignScoreToAttribute("Dexterity") })
                AssignableAttributeEditor(name = "Constitution", value = uiState.constitution, onClick = { viewModel.assignScoreToAttribute("Constitution") })
                AssignableAttributeEditor(name = "Intelligence", value = uiState.intelligence, onClick = { viewModel.assignScoreToAttribute("Intelligence") })
                AssignableAttributeEditor(name = "Wisdom", value = uiState.wisdom, onClick = { viewModel.assignScoreToAttribute("Wisdom") })
                AssignableAttributeEditor(name = "Charism", value = uiState.charism, onClick = { viewModel.assignScoreToAttribute("Charism") })
            }

            RpgButton(
                onClick = { viewModel.setAttributesAndMoveNext(onNavigateToRaceSelectionScreen) },
                text = "Next...",
                modifier = Modifier.padding(top = 24.dp),
                enabled = uiState.isAssignmentComplete
            )
        }
    }
}

@Composable
fun AssignableAttributeEditor(
    name: String,
    value: Int?,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(vertical = 8.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = value?.toString() ?: "--",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun ScoreChip(
    score: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
            .border(2.dp, borderColor, CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = score.toString(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroicAttributeRollingScreenPreview() {
    MyApplicationTheme {
        HeroicAttributeRollingScreen(onNavigateToRaceSelectionScreen = {})
    }
}