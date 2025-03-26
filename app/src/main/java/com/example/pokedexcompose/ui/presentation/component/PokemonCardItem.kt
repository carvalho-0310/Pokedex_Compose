package com.example.pokedexcompose.ui.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pokedexcompose.domain.model.PokemonInformation
import com.example.pokedexcompose.domain.model.fakeListPokemon
import com.example.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonCardItem(
    pokemon: PokemonInformation,
    onCardClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
        color =  Color.White,
        onClick = { onCardClick(pokemon.name) },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                modifier = modifier.padding(12.dp),
                model = pokemon.sprites,
                contentDescription = null
            )

            HorizontalDivider(modifier = Modifier.wrapContentSize(), color = Color.Black)

            Text(text = pokemon.id.toString())

            HorizontalDivider(modifier = Modifier.wrapContentSize(), color = Color.Black)

            Text(text = pokemon.name)
        }
    }
}

@Preview
@Composable
fun PokemonCardItemPreview() {
    PokedexComposeTheme {
        PokemonCardItem(
            pokemon = fakeListPokemon.first(), {}
        )
    }
}