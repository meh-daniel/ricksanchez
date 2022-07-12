package meh.daniel.com.ricksanchez.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import meh.daniel.com.ricksanchez.App
import meh.daniel.com.ricksanchez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory(App.charactersRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeViewModel()
    }

    private fun observeViewModel() {
        mainViewModel.charters.observe(this) {
            Log.d("xxx", "data: ${it}")
        }
    }
}