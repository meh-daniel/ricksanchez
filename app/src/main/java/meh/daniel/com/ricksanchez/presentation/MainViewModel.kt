package meh.daniel.com.ricksanchez.presentation

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import meh.daniel.com.ricksanchez.domain.CharactersRepository
import meh.daniel.com.ricksanchez.presentation.modelUI.CharactersUI
import meh.daniel.com.ricksanchez.presentation.modelUI.ListItem

class MainViewModel(private val repository: CharactersRepository) : ViewModel() {

    private var _charterNumber : Int = 1

    private val _charters : MutableLiveData<List<ListItem>> = MutableLiveData()
    val charters : LiveData<List<ListItem>> get() = _charters

    init {
        loadCharacter()
    }

    fun loadCharacter() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characters = repository.getCharacters()
                var listItems = mutableListOf<ListItem>()
                if (characters.results != null) {
                    listItems.add(
                        CharactersUI.Character(
                            "${characters.results[_charterNumber].gender}",
                            "${characters.results[_charterNumber].image}",
                            "${characters.results[_charterNumber].name}"
                        )
                    )
                    listItems.add(CharactersUI.Button("next Load"))
                }
                _charters.postValue(listItems)
            } catch (e: Throwable) {
                Log.e("ViewModelLog", "error in launcher MainViewModel", e)
            }
        }
    }

    fun createNewCharacterNumber(){
        _charterNumber++
    }

}

class MainViewModelFactory(private val repository: CharactersRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("MainViewModel class not found")
    }
}