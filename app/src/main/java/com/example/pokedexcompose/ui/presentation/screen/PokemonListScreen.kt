package com.example.pokedexcompose.ui.presentation.screen

import CustomTopBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedexcompose.domain.model.PokemonInformation
import com.example.pokedexcompose.domain.model.fakeListPokemon
import com.example.pokedexcompose.ui.PokemonViewModel
import com.example.pokedexcompose.ui.presentation.component.PokemonCardItem
import com.example.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonListScreen(
    viewModel: PokemonViewModel = hiltViewModel<PokemonViewModel>(),
    navigateToPokemonInformation: (String) -> Unit
) {
    val list = viewModel.pokemonList

    LaunchedEffect(viewModel.pokemonList.isEmpty()) {
        viewModel.initPokemonList()
    }

    ListContent(
        pokemonList = list,
        onAddItemClick = navigateToPokemonInformation,
        onNextPage = viewModel::getPokemonList
    )
}


@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    pokemonList: List<PokemonInformation>,
    onAddItemClick: (String) -> Unit,
    onNextPage: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        containerColor = Color.Red,
        topBar = { CustomTopBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = onNextPage) {}
        }
    ) { scaffoldPadding ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = modifier
                .padding(scaffoldPadding)
                .consumeWindowInsets(scaffoldPadding),
            contentPadding = PaddingValues(12.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(pokemonList) { pokemon ->
                PokemonCardItem(
                    pokemon,
                    onCardClick = { onAddItemClick(pokemon.name) }
                )
            }
        }
    }
}

@Preview
@Composable
fun ListPreview() {
    PokedexComposeTheme {
        ListContent(pokemonList = fakeListPokemon, onAddItemClick = { }, onNextPage = { })
    }
}
