package com.example.myapplication.ui.features.classicattributerolling

import ClassicAttributeRollingViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.RpgButton
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ClassicAttributeRollingScreen(onNavigateToRaceSelectionScreen: () -> Unit) {
    val viewModel = remember { ClassicAttributeRollingViewModel() }

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
                text = "Character Sheet",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Classic Mode",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )

            RpgButton(
                onClick = { viewModel.rollTheDices() },
                text = "Roll the dices",
                modifier = Modifier.padding(top = 16.dp)
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                RPGAttributeEditor(name = "Strength", value = viewModel.strength)
                RPGAttributeEditor(name = "Dexterity", value = viewModel.dexterity)
                RPGAttributeEditor(name = "Constitution", value = viewModel.constitution)
                RPGAttributeEditor(name = "Intelligence", value = viewModel.intelligence)
                RPGAttributeEditor(name = "Wisdom", value = viewModel.wisdom)
                RPGAttributeEditor(name = "Charisma", value = viewModel.charism)
            }

            RpgButton(
                onClick = { viewModel.setAttributesAndMoveNext(onNavigateToRaceSelectionScreen) },
                text = "Next...",
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}

@Composable
fun RPGAttributeEditor(
    name: String,
    value: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelLarge
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .border(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClassicAttributeRollingScreenPreview() {
    MyApplicationTheme {
        ClassicAttributeRollingScreen(onNavigateToRaceSelectionScreen = {})
    }
}