package meh.daniel.com.ricksanchez.presentation

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import meh.daniel.com.ricksanchez.data.model.CharactersNW
import meh.daniel.com.ricksanchez.domain.CharactersRepository

class MainViewModel(private val repository: CharactersRepository) : ViewModel() {

    private val _charters : MutableLiveData<List<CharactersNW.Result>> = MutableLiveData()
    val charters : LiveData<List<CharactersNW.Result>> get() = _charters

    init {
        viewModelScope.launch(Dispatchers.IO){
            try {
                val characters = repository.getCharacters()
                _charters.postValue(characters.results)
            } catch (e : Throwable){
                Log.e("xxx", "error in launcher MainViewModel", e)
            }
        }
    }
}

class MainViewModelFactory(private val repository: CharactersRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}