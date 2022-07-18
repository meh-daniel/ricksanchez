package meh.daniel.com.ricksanchez.presentation.modelUI

sealed class ListItem {
    abstract fun getType(): Int
    enum class Type {
        CHARACTER_TYPE,
        BUTTON_TYPE
    }
}

sealed class CharactersUI{
    data class Character(val gender: String,
                         val image: String,
                         val name: String) : ListItem() {
        override fun getType(): Int = Type.CHARACTER_TYPE.ordinal
    }
    data class Button(val titleName: String) : ListItem() {
        override fun getType(): Int = Type.BUTTON_TYPE.ordinal
    }
}