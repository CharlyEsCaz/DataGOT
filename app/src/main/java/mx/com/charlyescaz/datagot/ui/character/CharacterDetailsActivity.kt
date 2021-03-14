package mx.com.charlyescaz.datagot.ui.character

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityCharacterDetailsBinding
import mx.com.charlyescaz.datagot.interactors.CharacterInteractor
import mx.com.charlyescaz.datagot.ui.CustomActivity

class CharacterDetailsActivity: CustomActivity() {

    companion object{
        const val CHARACTER_NAME = "CHARACTER_NAME"
    }

    private lateinit var vBind: ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_character_details)
        super.setupBackButton(vBind.iToolbar.toolbar, R.color.secondary)
    }

    override fun onResume() {
        super.onResume()
        setupValues()
    }

    private fun setupValues(){
        val name = intent.getStringExtra(CHARACTER_NAME)

        if(name !== null){
            setupInfo(name)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupInfo(name: String){
        CharacterInteractor.retrieveCharacter(name){ character ->

            if(character == null){
                return@retrieveCharacter
            }

            vBind.character = character

            if(character.alive){
                vBind.tvAlive.text = "Yes"
            }else{
                vBind.tvAlive.text = "No"
                vBind.tvDeath.text = character.death.toString()
            }

            if(character.origin != null){
                vBind.tvOrigin.text = listToString(character.origin)
            }

            if(character.titles != null){
                vBind.tvTitles.text = listToString(character.titles)
            }

            if(character.siblings != null){
                vBind.tvSiblings.text = listToString(character.siblings)
            }

            if(character.spouse != null){
                vBind.tvSpouse.text = listToString(character.spouse)
            }

            if(character.lovers != null){
                vBind.tvLovers.text = listToString(character.lovers)
            }

            if(character.religions != null){
                vBind.tvReligion.text = listToString(character.religions)
            }

            if(character.allegiances != null){
                vBind.tvAllegiances.text = listToString(character.allegiances)
            }
        }
    }

    private fun listToString(list: List<String>): String{
        var text = ""

        if(list.size == 1){
            text = list[0]
        }else{
            for ((index, value) in list.withIndex()) {
                text += if(index == list.size -1 ){ value }else{ "$value, " }
            }
        }

        return text
    }
}