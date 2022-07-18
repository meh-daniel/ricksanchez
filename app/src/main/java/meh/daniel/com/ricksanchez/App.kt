package meh.daniel.com.ricksanchez

import android.app.Application
import meh.daniel.com.ricksanchez.data.CharactersApi
import meh.daniel.com.ricksanchez.data.CharactersRepositoryImpl
import meh.daniel.com.ricksanchez.domain.CharactersRepository

class App : Application() {
    companion object{
        lateinit var charactersRepository: CharactersRepository
            private set
    }
    override fun onCreate() {
        super.onCreate()
        initRepository()
    }
    private fun initRepository() {
        charactersRepository = CharactersRepositoryImpl(charactersApi = CharactersApi.createApiRickAndMorty())
    }
}