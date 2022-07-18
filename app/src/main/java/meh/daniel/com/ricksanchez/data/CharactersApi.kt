package meh.daniel.com.ricksanchez.data

import meh.daniel.com.ricksanchez.data.model.CharactersNW
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/api/"

interface CharactersApi {

    companion object{
        fun createApiRickAndMorty() : CharactersApi{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CharactersApi::class.java)
        }
    }

    @GET("character")
    suspend fun getCharacters() : CharactersNW

}