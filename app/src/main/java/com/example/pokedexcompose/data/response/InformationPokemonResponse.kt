package com.example.pokedexcompose.data.response

import com.google.gson.annotations.SerializedName

data class InformationPokemonResponse(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    @SerializedName("moves") val lisMoves: List<Moves>,
    @SerializedName("sprites") val sprites: Sprites,
   val types: List<Types>,
)

data class Moves(
    val move: Move,
)

data class Move(
    val name: String,
)

data class Sprites(
    @SerializedName("front_default") val imageToolbar: String,
    val other: Other
)

data class Other(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName("front_default") val imageUrl: String
)

data class Types(
    @SerializedName("type") val type: TypeName
)

data class TypeName(
    @SerializedName("name") val typeName: String
)
