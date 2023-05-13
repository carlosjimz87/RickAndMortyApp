package com.example.rickandmortyapp.utils

import com.example.rickandmortyapp.data.remote.models.Character
import com.example.rickandmortyapp.repositories.models.CharacterDetails

fun Character.toCharacterDetails(): CharacterDetails {
    return CharacterDetails(
        id = this.id,
        gender = this.gender,
        name = this.name,
        image = this.image,
        location = this.location,
        species = this.species,
        status = this.status,
        origin = this.origin

    )
}