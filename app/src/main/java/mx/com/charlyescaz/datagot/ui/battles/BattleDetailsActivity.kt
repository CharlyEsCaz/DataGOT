package mx.com.charlyescaz.datagot.ui.battles

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityBattleDetailsBinding
import mx.com.charlyescaz.datagot.interactors.BattleInteractor
import mx.com.charlyescaz.datagot.models.BattleViewModel
import mx.com.charlyescaz.datagot.ui.CustomActivity

class BattleDetailsActivity: CustomActivity() {

    companion object{
        const val BATTLE_NAME = "BATTLE_NAME"
    }

    private lateinit var vBind: ActivityBattleDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_battle_details)
        super.setupBackButton(vBind.iToolbar.toolbar, R.color.secondary)
    }

    override fun onResume() {
        super.onResume()
        setupValues()
    }

    private fun setupValues(){
        val name = intent.getStringExtra(BATTLE_NAME)

        if(name !== null){
            setupInfo(name)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupInfo(name: String){
        BattleInteractor.retrieveBattlesByName(name){ battles ->

            if(battles == null){
                return@retrieveBattlesByName
            }

            var battle = BattleViewModel()

            if(battles.isNotEmpty()){
                battle = battles[0]
            }

            vBind.battle = battle


            if(battle.places != null){
                vBind.tvPlaces.text = listToString(battle.places!!)
            }

            if(battle.factionsOne != null){
                vBind.tvFactionsOne.text = listToString(battle.factionsOne!!)
            }

            if(battle.commandersOne != null){
                vBind.tvCommandersOne.text = listToString(battle.commandersOne!!)
            }
            if(battle.forcesOne != null){
                vBind.tvForcesOne.text = listToString(battle.forcesOne!!)
            }

            if(battle.factionsTwo != null){
                vBind.tvFactionsTwo.text = listToString(battle.factionsTwo!!)
            }

            if(battle.commandersTwo != null){
                vBind.tvCommandersTwo.text = listToString(battle.commandersTwo!!)
            }
            if(battle.forcesTwo != null){
                vBind.tvForcesTwo.text = listToString(battle.forcesTwo!!)
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