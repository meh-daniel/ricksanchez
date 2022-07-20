package meh.daniel.com.ricksanchez.data

import meh.daniel.com.ricksanchez.data.model.CharactersNW
import meh.daniel.com.ricksanchez.domain.CharactersRepository

class CharactersRepositoryImpl(private val charactersApi: CharactersApi) :CharactersRepository {
    override suspend fun getCharacters(): CharactersNW {
        return charactersApi.getCharacters()
    }
}