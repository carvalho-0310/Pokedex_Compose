package com.example.pokedexcompose.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.pokedexcompose.domain.model.PokemonInformation
import com.example.pokedexcompose.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    var pokemonList by mutableStateOf<List<PokemonInformation>>(emptyList())
        private set

    var pokemonInformation by mutableStateOf<PokemonInformation?>(null)
        private set

    fun initPokemonList() {
        if (pokemonList.isEmpty())
            getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            pokemonList = repository.getListPokemon()
        }
    }

    fun getPokemonInformation(name: String) {
        if (pokemonInformation == null) {
            viewModelScope.launch {
                pokemonInformation = repository.getInformationPokemon(name)
            }
        }
    }
}
