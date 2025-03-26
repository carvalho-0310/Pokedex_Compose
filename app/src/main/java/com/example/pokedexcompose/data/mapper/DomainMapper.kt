package com.example.pokedexcompose.data.mapper

interface DomainMapper<T, Model> {
    fun toDomain(from: T): Model
    fun toDomain(from: List<T>): List<Model> = from.map { toDomain(it) }
}
