package com.example.pokedexcompose.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonInformation(
    val id: Int,
    val name: String,
    val height: String,
    val weight: String,
    val listMoves: List<String>,
    val spritesToolbar: String,
    val sprites: String,
    val types: List<TypePossible>,
)

enum class TypePossible(type: String) {
    BUG("bug"),
    DARK("dark"),
    DRAGON("dragon"),
    ELECTRIC("electric"),
    FAIRY("fairy"),
    FIGHTING("fighting"),
    FIRE("fire"),
    FLYING("flying"),
    GHOST("ghost"),
    GRASS("grass"),
    GROUND("ground"),
    ICE("ice"),
    NORMAL("normal"),
    POISON("poison"),
    PSYCHIC("psychic"),
    ROCK("rock"),
    STEEL("steel"),
    WATER("water"),
    UNKNOWN("unknown")
}


val fakeListPokemon = listOf(
    PokemonInformation(
        id = 1,
        name = "bulbasaur",
        height = "7",
        weight = "69",
        listMoves = listOf("a", "b"),
        spritesToolbar = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
        sprites = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
        types = listOf(TypePossible.ELECTRIC)
    ),
    PokemonInformation(
        id = 2,
        name = "ivysaur",
        height = "10",
        weight = "130",
        listMoves = listOf("a", "b"),
        spritesToolbar = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/2.svg",
        sprites = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
        types = listOf(TypePossible.GRASS)
    ),
    PokemonInformation(
        id = 3,
        name = "venusaur",
        height = "20",
        weight = "1000",
        listMoves = listOf("a", "b"),
        spritesToolbar = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/3.svg",
        sprites = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
        types = listOf(TypePossible.GHOST)
    )
)
