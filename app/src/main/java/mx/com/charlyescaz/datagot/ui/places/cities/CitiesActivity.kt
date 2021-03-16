package mx.com.charlyescaz.datagot.ui.places.cities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityGenericPlacesBinding
import mx.com.charlyescaz.datagot.interactors.PlaceInteractor
import mx.com.charlyescaz.datagot.ui.CustomActivity
import mx.com.charlyescaz.datagot.ui.places.cities.adapter.CityAdapter

class CitiesActivity: CustomActivity() {

    private lateinit var vBind: ActivityGenericPlacesBinding
    private lateinit var adapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_generic_places)

        setupAdapter()
        setupRecyclerView()

        super.setupBackButton(vBind.iToolbar.toolbar, R.color.secondary)
    }

    private fun setupAdapter(){
        vBind.pbLoading.visibility = View.VISIBLE
        vBind.lblEmpty.visibility = View.GONE

        PlaceInteractor.retrieveCities { cities ->
            vBind.pbLoading.visibility = View.GONE

            if(cities == null){
                return@retrieveCities
            }

            if(cities.isEmpty()){
                vBind.lblEmpty.visibility = View.VISIBLE
            }else{
                adapter = CityAdapter(cities){ city ->
                    val intent = Intent(this, CityDetailsActivity::class.java)
                    intent.putExtra(CityDetailsActivity.PLACE_NAME, city.name)
                    startActivity(intent)
                }
                vBind.rvCities.adapter = adapter
            }
        }
    }

    private fun setupRecyclerView(){
        vBind.rvCities.layoutManager = LinearLayoutManager(this)
        vBind.rvCities.itemAnimator = DefaultItemAnimator()
    }
}