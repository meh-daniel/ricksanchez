package meh.daniel.com.ricksanchez.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import meh.daniel.com.ricksanchez.data.model.CharactersNW
import meh.daniel.com.ricksanchez.databinding.ItemButtonBinding
import meh.daniel.com.ricksanchez.databinding.ItemCharacterBinding

private const val CHARACTER_TYPE = 1010
private const val BUTTON_TYPE = 1100

class CharactersAdapter : ListAdapter<CharactersNW.Result, RecyclerView.ViewHolder>(weatherDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType){
        CHARACTER_TYPE -> {
            val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            CharacterViewHolder(binding)
        }
        BUTTON_TYPE -> {
            val binding = ItemButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ButtonViewHolder(binding)
        }
        else -> {
            throw IllegalArgumentException("fuck onCreateViewHolder")
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            CHARACTER_TYPE -> (holder as CharacterViewHolder).bind(item = getItem(position))
            BUTTON_TYPE -> (holder as ButtonViewHolder)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(true){
            CHARACTER_TYPE
        } else{
            BUTTON_TYPE
        }
    }

}

//sealed class CharactersUI{
//    data class Character( val results: List<Result>){
//        data class Result(
//            val gender: String,
//            val image: String,
//            val name: String
//        )
//    }
//    data class Button(val title: String)
//}

class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: CharactersNW.Result){
        binding.tvName.text = item.name
        binding.tvGender.text = item.gender
        Glide.with(binding.ivAvatar)
            .load(item.image)
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