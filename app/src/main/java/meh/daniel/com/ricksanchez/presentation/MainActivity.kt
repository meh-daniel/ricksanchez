package meh.daniel.com.ricksanchez.presentation

import android.content.Context
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display
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

        getDisplaySize()
    }

    private fun getDisplaySize() : Int{
        val display: Display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        val screenHeight: Int = point.y
        val height = convertPixelsToDp(this, screenHeight.toFloat())
        return height.toInt() / 100
    }

    private fun convertPixelsToDp(context: Context, pixels: Float) =
        pixels / context.resources.displayMetrics.density

    private fun observeViewModel() {
        mainViewModel.charters.observe(this) {
            Log.d("xxx", "data: ${it}")
        }
    }
}