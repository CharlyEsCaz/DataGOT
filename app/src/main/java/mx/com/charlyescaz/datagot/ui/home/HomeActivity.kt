package mx.com.charlyescaz.datagot.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityHomeBinding
import mx.com.charlyescaz.datagot.interactors.CharacterInteractor
import mx.com.charlyescaz.datagot.ui.CustomActivity
import mx.com.charlyescaz.datagot.ui.battles.BattlesActivity
import mx.com.charlyescaz.datagot.ui.character.CharactersActivity
import mx.com.charlyescaz.datagot.ui.places.PlacesActivity

class HomeActivity: CustomActivity() {

    private lateinit var vBind: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setupMenu()
    }

    private fun setupMenu(){
        vBind.cvCharacters.setOnClickListener {
            startActivity( Intent(this, CharactersActivity::class.java) )
        }

        vBind.cvBattles.setOnClickListener {
            startActivity( Intent(this, BattlesActivity::class.java) )
        }

        vBind.cvPlaces.setOnClickListener {
            startActivity( Intent(this, PlacesActivity::class.java) )
        }

        vBind.cvEpisodes.setOnClickListener {

        }

        vBind.cvHouses.setOnClickListener {

        }

        vBind.cvReligions.setOnClickListener {

        }
    }
}