package com.example.rickandmortyapp.repositories.models

import com.example.rickandmortyapp.data.remote.models.Location
import com.example.rickandmortyapp.data.remote.models.Origin

data class CharacterDetails(
    val id: Int,
    val name: String,
    val gender: String,
    val image: String,
    val location: Location,
    val origin: Origin,
    val species: String,
    val status: String
)
