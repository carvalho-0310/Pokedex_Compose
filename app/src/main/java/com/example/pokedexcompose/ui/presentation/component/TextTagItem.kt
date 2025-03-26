package com.example.pokedexcompose.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.pokedexcompose.domain.model.TypePossible
import com.example.pokedexcompose.domain.model.fakeListPokemon
import com.example.pokedexcompose.ui.theme.BlackPokemon
import com.example.pokedexcompose.ui.theme.Bug
import com.example.pokedexcompose.ui.theme.Dark
import com.example.pokedexcompose.ui.theme.Dragon
import com.example.pokedexcompose.ui.theme.Electric
import com.example.pokedexcompose.ui.theme.Fairy
import com.example.pokedexcompose.ui.theme.Fighting
import com.example.pokedexcompose.ui.theme.Fire
import com.example.pokedexcompose.ui.theme.Flying
import com.example.pokedexcompose.ui.theme.Ghost
import com.example.pokedexcompose.ui.theme.Grass
import com.example.pokedexcompose.ui.theme.Ground
import com.example.pokedexcompose.ui.theme.Ice
import com.example.pokedexcompose.ui.theme.Normal
import com.example.pokedexcompose.ui.theme.Poison
import com.example.pokedexcompose.ui.theme.Psychic
import com.example.pokedexcompose.ui.theme.Rock
import com.example.pokedexcompose.ui.theme.Steel
import com.example.pokedexcompose.ui.theme.Water
import com.example.pokedexcompose.ui.theme.WhitePokemon

@Composable
fun TextTagItem(
    modifier: Modifier = Modifier,
    text: String,
    type: TypePossible = TypePossible.UNKNOWN,
    fontSize: TextUnit = TextUnit.Unspecified
) {

    Box(
        modifier = Modifier
            .background(getTypeColor(type), shape = RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = BlackPokemon, fontWeight = FontWeight.Bold, fontSize = fontSize)
    }
}

private fun getTypeColor(type: TypePossible) = when (type) {
    TypePossible.BUG -> Bug
    TypePossible.DARK -> Dark
    TypePossible.DRAGON -> Dragon
    TypePossible.ELECTRIC -> Electric
    TypePossible.FAIRY -> Fairy
    TypePossible.FIGHTING -> Fighting
    TypePossible.FIRE -> Fire
    TypePossible.FLYING -> Flying
    TypePossible.GHOST -> Ghost
    TypePossible.GRASS -> Grass
    TypePossible.GROUND -> Ground
    TypePossible.ICE -> Ice
    TypePossible.NORMAL -> Normal
    TypePossible.POISON -> Poison
    TypePossible.PSYCHIC -> Psychic
    TypePossible.ROCK -> Rock
    TypePossible.STEEL -> Steel
    TypePossible.WATER -> Water
    TypePossible.UNKNOWN -> WhitePokemon
}

@Preview()
@Composable
fun TextTagItemPreview() {
    TextTagItem(
        text = fakeListPokemon.first().types.first().name,
        type = fakeListPokemon.first().types.first()
    )
}