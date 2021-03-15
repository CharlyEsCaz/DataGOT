package mx.com.charlyescaz.datagot.ui.places

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityPlacesBinding
import mx.com.charlyescaz.datagot.ui.CustomActivity
import mx.com.charlyescaz.datagot.ui.places.continents.ContinentActivity

class PlacesActivity: CustomActivity() {

    private lateinit var vBind: ActivityPlacesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_places)
        super.setupBackButton(vBind.iToolbar.toolbar, R.color.secondary)
        setupMenu()
    }

    private fun setupMenu(){

        vBind.cvContinents.setOnClickListener {
            startActivity( Intent(this, ContinentActivity::class.java) )
        }

        vBind.cvCities.setOnClickListener {

        }

        vBind.cvCastles.setOnClickListener {

        }
    }

}