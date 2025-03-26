package com.example.pokedexcompose.di

import com.example.pokedexcompose.data.mapper.DomainMapper
import com.example.pokedexcompose.data.response.InformationPokemonResponse
import com.example.pokedexcompose.data.mapper.PokemonMapperImpl
import com.example.pokedexcompose.data.repository.PokemonRepositoryImpl
import com.example.pokedexcompose.domain.model.PokemonInformation
import com.example.pokedexcompose.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @JvmSuppressWildcards
    abstract fun bindPokemonMapper(pokemonMapperImpl: PokemonMapperImpl): DomainMapper<InformationPokemonResponse, PokemonInformation>

    @Binds
    abstract fun bindPokemonRepository(repositoryImpl: PokemonRepositoryImpl): PokemonRepository
}