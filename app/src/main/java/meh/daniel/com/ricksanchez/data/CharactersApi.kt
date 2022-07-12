package meh.daniel.com.ricksanchez.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://rickandmortyapi.com/api/"

class CharactersApi {

    companion object{
        fun createApi() : CharactersApi{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CharactersApi::class.java)
        }
    }

}