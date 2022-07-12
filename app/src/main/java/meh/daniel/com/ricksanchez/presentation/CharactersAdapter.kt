package meh.daniel.com.ricksanchez.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import meh.daniel.com.ricksanchez.data.model.CharactersNW
import meh.daniel.com.ricksanchez.databinding.ItemButtonBinding
import meh.daniel.com.ricksanchez.databinding.ItemCharacterBinding

class CharactersAdapter : ListAdapter<CharactersNW.Result, RecyclerView.ViewHolder>(weatherDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

sealed class CharactersUI{
    data class Character(val urlAvatar: String, val name: String, val gender: String)
    data class Button(val title: String)
}

class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: CharactersUI.Character){
        binding.tvName.text = item.name
        binding.tvGender.text = item.gender
        Glide.with(binding.ivAvatar)
            .load(item.urlAvatar)
            .into(binding.ivAvatar)
    }
}

class ButtonViewHolder(private val binding: ItemButtonBinding) : RecyclerView.ViewHolder(binding.root)

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