package com.example.pokedexcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pokedexcompose.ui.presentation.screen.PokemonInformationScreen
import com.example.pokedexcompose.ui.presentation.screen.PokemonListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListRoute

@Serializable
data class PokemonInformationRoute(val pokemon: String)

@Composable
fun PokedexNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ListRoute) {
        composable<ListRoute> {
            PokemonListScreen {
                navController.navigate(PokemonInformationRoute(it))
            }
        }

        composable<PokemonInformationRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<PokemonInformationRoute>()
            PokemonInformationScreen( pokemon = route.pokemon)
        }
    }
}
