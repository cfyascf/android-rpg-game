package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.domain.entities.AttributeRollingModes
import com.example.myapplication.ui.features.adventureattributerolling.AdventureAttributeRollingScreen
import com.example.myapplication.ui.features.classicattributerolling.ClassicAttributeRollingScreen
import com.example.myapplication.ui.features.heroicattributerolling.HeroicAttributeRollingScreen
import com.example.myapplication.ui.features.namechampion.NameChampionScreen
import com.example.myapplication.ui.features.selectarchetype.SelectArchetypeScreen
import com.example.myapplication.ui.features.selectattributerollingmode.SelectAttributeRollingModeScreen
import com.example.myapplication.ui.features.selectrace.SelectRaceScreen
import com.example.myapplication.ui.features.welcome.WelcomeScreen

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome_screen")
    object NameChampion : Screen("name_champion_screen")
    object SelectAttributeRollingMode : Screen("select_attribute_rolling_mode_screen")
    object ClassicAttributeRolling : Screen("classic_attribute_rolling_screen")
    object AdventureAttributeRolling : Screen("adventure_attribute_rolling_screen")
    object HeroicAttributeRolling : Screen("heroic_attribute_rolling_screen")
    object SelectRace : Screen("select_race_screen")
    object SelectArchetype : Screen("select_archetype_screen")
    object ReviewChampion : Screen("review_champion_screen")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(
                onNavigateToNameChampionScreen = {
                    navController.navigate(Screen.NameChampion.route)
                }
            )
        }

        composable(route = Screen.NameChampion.route) {
            NameChampionScreen(
                onNavigateToModeSelectionScreen = {
                    navController.navigate(Screen.SelectAttributeRollingMode.route)
                }
            )
        }

        composable(route = Screen.SelectAttributeRollingMode.route) {
            SelectAttributeRollingModeScreen(
                onMoveToModeSelectedScreen = { selectedMode ->
                    val nextRoute = when (selectedMode) {
                        AttributeRollingModes.CLASSIC -> Screen.ClassicAttributeRolling.route
                        AttributeRollingModes.ADVENTURE -> Screen.AdventureAttributeRolling.route
                        AttributeRollingModes.HEROIC -> Screen.HeroicAttributeRolling.route
                    }

                    navController.navigate(nextRoute)
                }
            )
        }

        composable(route = Screen.ClassicAttributeRolling.route) {
            ClassicAttributeRollingScreen(onNavigateToRaceSelectionScreen = {
                navController.navigate(Screen.SelectRace.route)
            })
        }

        composable(route = Screen.AdventureAttributeRolling.route) {
            AdventureAttributeRollingScreen(onNavigateToRaceSelectionScreen = {
                navController.navigate(Screen.SelectRace.route)
            })
        }

        composable(route = Screen.HeroicAttributeRolling.route) {
            HeroicAttributeRollingScreen(onNavigateToRaceSelectionScreen = {
                navController.navigate(Screen.SelectRace.route)
            })
        }

        composable(route = Screen.SelectRace.route) {
            SelectRaceScreen(onMoveToSelectArchetypeScreen = {
                navController.navigate(Screen.SelectArchetype.route)
            })
        }

        composable(route = Screen.SelectArchetype.route) {
            SelectArchetypeScreen(onMoveToReviewChampionScreen = {
                navController.navigate(Screen.ReviewChampion.route)
            })
        }
    }
}