package com.example.myapplication.ui.features.reviewchampion

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.components.RpgButton
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ReviewChampionScreen(
    viewModel: ReviewChampionViewModel = viewModel(),
    onNavigateToGameScreen: () -> Unit
) {
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
                text = "Confirm Your Champion",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = viewModel.creationState.name ?: "Nameless Hero",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            ReviewStatItem(label = "Race", value = viewModel.creationState.race?.toString() ?: "Not Selected")
            ReviewStatItem(label = "Archetype", value = viewModel.creationState.archetype?.toString() ?: "Not Selected")
            ReviewStatItem(label = "Attribute Mode", value = viewModel.creationState.mode?.toString() ?: "Not Selected")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    ReviewStatItem(label = "Strength", value = viewModel.creationState.strength?.toString() ?: "--")
                    ReviewStatItem(label = "Dexterity", value = viewModel.creationState.dexterity?.toString() ?: "--")
                    ReviewStatItem(label = "Constitution", value = viewModel.creationState.constitution?.toString() ?: "--")
                }
                Column(horizontalAlignment = Alignment.Start) {
                    ReviewStatItem(label = "Intelligence", value = viewModel.creationState.intelligence?.toString() ?: "--")
                    ReviewStatItem(label = "Wisdom", value = viewModel.creationState.wisdom?.toString() ?: "--")
                    ReviewStatItem(label = "Charisma", value = viewModel.creationState.charism?.toString() ?: "--")
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            RpgButton(
                text = "Start Game!",
                onClick = { viewModel.createChampion() },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ReviewStatItem(label: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ReviewChampionScreenPreview() {
    MyApplicationTheme {
        ReviewChampionScreen(onNavigateToGameScreen = {})
    }
}