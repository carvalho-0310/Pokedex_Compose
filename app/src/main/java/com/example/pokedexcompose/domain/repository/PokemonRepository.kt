package com.example.pokedexcompose.domain.repository

import com.example.pokedexcompose.domain.model.PokemonInformation


interface PokemonRepository {
    suspend fun getListPokemon() : List<PokemonInformation>
    suspend fun getInformationPokemon(name :String) : PokemonInformation
}
