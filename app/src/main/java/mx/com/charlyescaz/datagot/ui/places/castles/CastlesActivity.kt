package mx.com.charlyescaz.datagot.ui.places.castles

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
import mx.com.charlyescaz.datagot.ui.places.castles.adapter.CastleAdapter

class CastlesActivity: CustomActivity() {

    private lateinit var vBind: ActivityGenericPlacesBinding
    private lateinit var adapter: CastleAdapter

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

        PlaceInteractor.retrieveCastles { castles ->
            vBind.pbLoading.visibility = View.GONE

            if(castles == null){
                return@retrieveCastles
            }

            if(castles.isEmpty()){
                vBind.lblEmpty.visibility = View.VISIBLE
            }else{
                adapter = CastleAdapter(castles){ city ->
                    val intent = Intent(this, CastleDetailsActivity::class.java)
                    intent.putExtra(CastleDetailsActivity.PLACE_NAME, city.name)
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