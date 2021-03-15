package mx.com.charlyescaz.datagot.ui.places.continents.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ItemContinentBinding
import mx.com.charlyescaz.datagot.models.ContinentViewModel

class ContinentAdapter(private val continents: List<ContinentViewModel>, private val context: Context)
    : RecyclerView.Adapter<ContinentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_continent, parent, false)
        )
    }

    override fun getItemCount(): Int = continents.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val continent = continents[position]

        holder.holderBinding.continent = continent

        if(continent.neighbors != null){

            holder.holderBinding.llNeighbors.removeAllViews()

            continent.neighbors.forEach { neighbor ->
                val tvNeighbor = TextView(context)
                tvNeighbor.text = neighbor
                tvNeighbor.setTextColor(ContextCompat.getColor(context, R.color.secondary))
                holder.holderBinding.llNeighbors.addView(tvNeighbor)
            }
        }
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val holderBinding = ItemContinentBinding.bind(itemView)
    }
}