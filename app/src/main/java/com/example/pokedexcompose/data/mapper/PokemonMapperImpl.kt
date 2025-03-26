package com.example.pokedexcompose.data.mapper

import com.example.pokedexcompose.data.response.InformationPokemonResponse
import com.example.pokedexcompose.data.response.Types
import com.example.pokedexcompose.domain.model.PokemonInformation
import com.example.pokedexcompose.domain.model.TypePossible
import javax.inject.Inject
import kotlin.collections.map

class PokemonMapperImpl @Inject constructor() :
    DomainMapper<InformationPokemonResponse, PokemonInformation> {

    override fun toDomain(from: InformationPokemonResponse): PokemonInformation {
        return PokemonInformation(
            id = from.id,
            name = from.name,
            height = from.height.toString(),
            weight = from.weight.toString(),
            listMoves = from.lisMoves.map { it.move.name },
            spritesToolbar = from.sprites.imageToolbar,
            sprites = from.sprites.other.officialArtwork.imageUrl,
            types = from.types.map { typesNames(it.type.typeName) }
        )
    }

    private fun typesNames(type: String) =
        when (type.uppercase()) {
            TypePossible.BUG.name -> TypePossible.BUG
            TypePossible.DARK.name -> TypePossible.DARK
            TypePossible.DRAGON.name -> TypePossible.DRAGON
            TypePossible.ELECTRIC.name -> TypePossible.ELECTRIC
            TypePossible.FAIRY.name -> TypePossible.FAIRY
            TypePossible.FIGHTING.name -> TypePossible.FIGHTING
            TypePossible.FIRE.name -> TypePossible.FIRE
            TypePossible.FLYING.name -> TypePossible.FLYING
            TypePossible.GHOST.name -> TypePossible.GHOST
            TypePossible.GRASS.name -> TypePossible.GRASS
            TypePossible.GROUND.name -> TypePossible.GROUND
            TypePossible.ICE.name -> TypePossible.ICE
            TypePossible.NORMAL.name -> TypePossible.NORMAL
            TypePossible.POISON.name -> TypePossible.POISON
            TypePossible.PSYCHIC.name -> TypePossible.PSYCHIC
            TypePossible.ROCK.name -> TypePossible.ROCK
            TypePossible.STEEL.name -> TypePossible.STEEL
            TypePossible.WATER.name -> TypePossible.WATER
            else -> TypePossible.UNKNOWN
        }
}


