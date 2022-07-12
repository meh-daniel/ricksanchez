package meh.daniel.com.ricksanchez.data

import meh.daniel.com.ricksanchez.data.model.CharactersNw
import meh.daniel.com.ricksanchez.domain.CharactersRepository

class CharactersRepositoryImpl(private val charactersApi: CharactersApi) :CharactersRepository {
    override suspend fun getCharacters(): CharactersNw {
        return charactersApi.getCharacters()
    }
}