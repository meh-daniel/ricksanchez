package meh.daniel.com.ricksanchez.domain

import meh.daniel.com.ricksanchez.data.model.CharactersNw

interface CharactersRepository {
    suspend fun getCharacters() : CharactersNw
}