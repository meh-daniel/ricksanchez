package meh.daniel.com.ricksanchez.domain

import meh.daniel.com.ricksanchez.data.model.CharactersNW

interface CharactersRepository {
    suspend fun getCharacters() : CharactersNW
}