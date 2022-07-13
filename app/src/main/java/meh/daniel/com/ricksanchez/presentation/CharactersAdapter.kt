package meh.daniel.com.ricksanchez.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import meh.daniel.com.ricksanchez.databinding.ItemButtonBinding
import meh.daniel.com.ricksanchez.databinding.ItemCharacterBinding
import meh.daniel.com.ricksanchez.presentation.modelUI.CharactersUI
import meh.daniel.com.ricksanchez.presentation.modelUI.ListItem

class CharactersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<ListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            ListItem.Type.CHARACTER_TYPE.ordinal-> {
                val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CharacterViewHolder(binding)
            }
            ListItem.Type.BUTTON_TYPE.ordinal -> {
                val binding = ItemButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ButtonViewHolder(binding)
            }
            else ->  throw IllegalArgumentException("fuck onCreateViewHolder")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CharacterViewHolder -> holder.bind(items[position] as CharactersUI.Character)
            is ButtonViewHolder-> holder.bind(items[position] as CharactersUI.Button)
            else -> throw Exception(" Unknown view type exception")
        }
    }

    fun setItems(newItem: List<ListItem>) {
        items.apply {
            clear()
            addAll(newItem)
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int = items[position].getType()

    override fun getItemCount() = items.size

}

class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: CharactersUI.Character){
        binding.tvName.text = item.name
        binding.tvGender.text = item.gender
        Glide.with(binding.ivAvatar)
            .load(item.image)
            .into(binding.ivAvatar)
    }
}

class ButtonViewHolder(private val binding: ItemButtonBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: CharactersUI.Button){
        binding.bLoad.text = item.titleName
    }
}
