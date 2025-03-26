package com.example.pokedexcompose.data.repository

import com.example.pokedexcompose.data.mapper.DomainMapper
import com.example.pokedexcompose.data.response.InformationPokemonResponse
import com.example.pokedexcompose.domain.repository.PokemonRepository
import com.example.pokedexcompose.domain.model.PokemonInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val LAST_POKEMON = 493

class PokemonRepositoryImpl @Inject constructor(
    private val mapperPokemon: DomainMapper<InformationPokemonResponse, PokemonInformation>,
    private val api: PokemonApi
) : PokemonRepository {

    private var offset = 0
    private var limit = 20
    private var pokemonList: MutableList<PokemonInformation> = mutableListOf()

    override suspend fun getListPokemon(): List<PokemonInformation> {
        return if (offset < LAST_POKEMON) {
            withContext(Dispatchers.IO) {
                val response = api.getListPokemon(limit, offset)

                val pokemonInfoList = response.results.map { pokemon ->
                    async {
                        mapperPokemon.toDomain(api.getInformationPokemon(pokemon.name))
                    }
                }.awaitAll()

                pokemonList.addAll(pokemonInfoList)

                updatePagination()

                pokemonList.toList()
            }
        } else
            emptyList()
    }

    private fun updatePagination() {
        offset += limit
        if ((offset + limit) >= LAST_POKEMON) {
            limit = LAST_POKEMON - offset
        }
    }

    override suspend fun getInformationPokemon(name: String): PokemonInformation =
        withContext(Dispatchers.IO) { mapperPokemon.toDomain(api.getInformationPokemon(name)) }

}
