package mx.com.charlyescaz.datagot.ui.home

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityHomeBinding
import mx.com.charlyescaz.datagot.interactors.CharacterInteractor
import mx.com.charlyescaz.datagot.ui.CustomActivity

class HomeActivity: CustomActivity() {

    private lateinit var vBind: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setupNoNavigation()

        CharacterInteractor.retrieveCharacter("Jon Snow"){ character ->
            if(character == null){

            }
        }
    }
}