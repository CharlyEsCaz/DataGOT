package mx.com.charlyescaz.datagot.ui.places.cities.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ItemGenericPlaceBinding
import mx.com.charlyescaz.datagot.models.PlaceViewModel

class CityAdapter(private val cities: List<PlaceViewModel>,
                  private val onClick: ( city: PlaceViewModel) -> Unit)
    : RecyclerView.Adapter<CityAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_generic_place, parent, false)
        )
    }

    override fun getItemCount(): Int = cities.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = cities[position]

        holder.holderBinding.place = place
        holder.holderBinding.cvPlace.setOnClickListener {
            onClick(place)
        }
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val holderBinding = ItemGenericPlaceBinding.bind(itemView)
    }
}