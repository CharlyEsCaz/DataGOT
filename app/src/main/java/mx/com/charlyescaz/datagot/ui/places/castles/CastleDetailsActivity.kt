package mx.com.charlyescaz.datagot.ui.places.castles

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityPlaceDetailsBinding
import mx.com.charlyescaz.datagot.interactors.PlaceInteractor
import mx.com.charlyescaz.datagot.models.PlaceViewModel
import mx.com.charlyescaz.datagot.ui.CustomActivity
import mx.com.charlyescaz.datagot.utils.ModelExtensions

class CastleDetailsActivity: CustomActivity() {

    companion object {
        const val PLACE_NAME = "PLACE_NAME"
    }

    private lateinit var vBind: ActivityPlaceDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_place_details)

        super.setupBackButton(vBind.iToolbar.toolbar, R.color.secondary)
        setupValues()
    }

    private fun setupValues() {
        val name = intent.getStringExtra(PLACE_NAME)

        if (name != null) {

            PlaceInteractor.retrieveCastlesByName(name) { castles ->

                if (castles == null) {
                    return@retrieveCastlesByName
                }

                if (castles.isNotEmpty()) {
                    setupInfo(castles[0])
                }
            }
        }
    }

    private fun setupInfo(place: PlaceViewModel){
        vBind.place = place

        if(place.founder != null){
            vBind.tvFounders.text = ModelExtensions.listToString(place.founder)
        }

        if(place.rulers != null){
            vBind.tvRulers.text = ModelExtensions.listToString(place.rulers)
        }

        if(place.religion != null){
            vBind.tvReligion.text = ModelExtensions.listToString(place.religion)
        }
    }
}