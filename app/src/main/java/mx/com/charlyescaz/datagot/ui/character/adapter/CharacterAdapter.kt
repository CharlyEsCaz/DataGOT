package mx.com.charlyescaz.datagot.ui.character.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ItemCharacterBinding
import mx.com.charlyescaz.datagot.models.CharacterViewModel

class CharacterAdapter(private val characters: List<CharacterViewModel>, private val onClick: ( character: CharacterViewModel) -> Unit): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_character, parent, false)
        )
    }

    override fun getItemCount(): Int = characters.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]

        holder.holderBinding.character = character
        holder.holderBinding.cvCharacter.setOnClickListener {
            onClick(character)
        }
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val holderBinding = ItemCharacterBinding.bind(itemView)
    }
}