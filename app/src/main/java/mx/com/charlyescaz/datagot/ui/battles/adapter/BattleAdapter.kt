package mx.com.charlyescaz.datagot.ui.battles.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ItemBattleBinding
import mx.com.charlyescaz.datagot.models.BattleViewModel

class BattleAdapter(private val battles: List<BattleViewModel>,
                    private val onClick: ( battle: BattleViewModel) -> Unit)
    : RecyclerView.Adapter<BattleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_battle, parent, false)
        )
    }

    override fun getItemCount(): Int = battles.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val battle = battles[position]

        holder.holderBinding.battle = battle
        holder.holderBinding.cvBattle.setOnClickListener {
            onClick(battle)
        }
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val holderBinding = ItemBattleBinding.bind(itemView)
    }
}