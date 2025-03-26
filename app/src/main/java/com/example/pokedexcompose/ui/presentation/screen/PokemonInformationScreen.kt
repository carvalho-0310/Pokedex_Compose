package com.example.pokedexcompose.ui.presentation.screen

import CustomTopBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.pokedexcompose.domain.model.PokemonInformation
import com.example.pokedexcompose.domain.model.fakeListPokemon
import com.example.pokedexcompose.ui.PokemonViewModel
import com.example.pokedexcompose.ui.presentation.component.TextTagItem
import com.example.pokedexcompose.ui.theme.PokedexComposeTheme
import com.example.pokedexcompose.R

@Composable
fun PokemonInformationScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = hiltViewModel(),
    pokemon: String
) {
    LaunchedEffect(viewModel.pokemonInformation == null) {
        viewModel.getPokemonInformation(pokemon)
    }

    viewModel.pokemonInformation?.let {
        PokemonInformationContent(it)
    }
}

@Composable
fun PokemonInformationContent(pokemon: PokemonInformation, modifier: Modifier = Modifier) {

    Scaffold(
        modifier = modifier,
        containerColor = Color.Red,
        topBar = {
            CustomTopBar(
                sprite = pokemon.spritesToolbar,
                text = stringResource(R.string.pokemon_name, pokemon.id, pokemon.name)
            )
        }
    ) { scaffoldPadding ->

        Column(
            modifier = modifier
                .background(Color.White)
                .padding(scaffoldPadding)
                .consumeWindowInsets(scaffoldPadding),
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {

                Column {
                    Text(stringResource(R.string.weight, pokemon.weight), fontSize = 14.sp)
                    Text(stringResource(R.string.height, pokemon.height), fontSize = 14.sp)
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        AsyncImage(
                            model = pokemon.sprites,
                            contentDescription = null,
                            modifier = Modifier.size(150.dp)
                        )
                    }
                }
            }

            HorizontalDivider(thickness = 4.dp, color = Color.Black)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.type),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    items(items = pokemon.types) { type ->
                        TextTagItem(text = type.name, type = type)
                    }
                }
            }

            HorizontalDivider(thickness = 4.dp, color = Color.Black)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Red)
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.moves),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                LazyRow(
                    modifier = Modifier.padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(pokemon.listMoves) { move ->
                        TextTagItem(text = move)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PokemonInformationPreview() {
    PokedexComposeTheme {
        PokemonInformationContent(pokemon = fakeListPokemon.first())
    }
}
