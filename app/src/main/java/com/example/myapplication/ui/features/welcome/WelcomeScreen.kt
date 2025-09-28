package com.example.myapplication.ui.features.welcome

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.entities.Game
import com.example.myapplication.ui.theme.*

@Composable
fun WelcomeScreen(onNavigateToNameChampionScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackgroundColor)
            .clickable { onNavigateToNameChampionScreen() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(RoundedCornerShape(8.dp))
                .background(ParchmentColor)
                .border(2.dp, DarkBrownColor, RoundedCornerShape(8.dp))
                .padding(horizontal = 24.dp, vertical = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "Hello, welcome to",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Old Dragon!",
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )

            Text(
                text = "From now on you will be a champion.\nLets start by building your character.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            val infiniteTransition = rememberInfiniteTransition(label = "pulse")
            val animatedAlpha by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 0.4f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1500, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                ), label = "alpha"
            )

            Text(
                text = "(Touch the screen to continue...)",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .graphicsLayer { alpha = animatedAlpha },
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    MyApplicationTheme {
        WelcomeScreen(onNavigateToNameChampionScreen = {})
    }
}