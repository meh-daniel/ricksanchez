package meh.daniel.com.ricksanchez.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import meh.daniel.com.ricksanchez.App
import meh.daniel.com.ricksanchez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val charactersAdapter = CharactersAdapter(::onClickItemButtonLoad)

    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory(App.charactersRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeViewModel()
        initRecyclerView()
    }

    private fun observeViewModel() {
        mainViewModel.charters.observe(this) {
            charactersAdapter.setItems(it)
        }
    }

    private fun onClickItemButtonLoad(flag: Int) : Int {
        mainViewModel.createNewCharacterNumber()
        mainViewModel.getCharacter()
        return Log.d("xxx", flag.toString())
    }

    private fun initRecyclerView() {
        binding.rvCharacters.adapter = charactersAdapter
        binding.rvCharacters.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}