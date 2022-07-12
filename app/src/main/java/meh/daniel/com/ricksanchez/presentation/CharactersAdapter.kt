package meh.daniel.com.ricksanchez.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import meh.daniel.com.ricksanchez.data.model.CharactersNW

class CharactersAdapter : ListAdapter<CharactersNW.Result, RecyclerView.ViewHolder>(weatherDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}



val weatherDiffUtil = object : DiffUtil.ItemCallback<CharactersNW.Result>() {
    override fun areItemsTheSame(
        oldItem: CharactersNW.Result,
        newItem: CharactersNW.Result
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: CharactersNW.Result,
        newItem: CharactersNW.Result
    ): Boolean = oldItem == newItem

}