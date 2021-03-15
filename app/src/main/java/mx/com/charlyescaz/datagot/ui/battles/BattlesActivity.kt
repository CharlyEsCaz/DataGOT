package mx.com.charlyescaz.datagot.ui.battles

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityBattlesBinding
import mx.com.charlyescaz.datagot.interactors.BattleInteractor
import mx.com.charlyescaz.datagot.ui.CustomActivity
import mx.com.charlyescaz.datagot.ui.battles.adapter.BattleAdapter

class BattlesActivity: CustomActivity() {

    private lateinit var vBind: ActivityBattlesBinding
    private lateinit var adapter: BattleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_battles)
        super.setupBackButton(vBind.iToolbar.toolbar, R.color.secondary)
        setupRecyclerView()
        setupAdapter()
    }

    private fun setupAdapter(){
        vBind.pbLoading.visibility = View.VISIBLE
        vBind.lblEmpty.visibility = View.GONE

        BattleInteractor.retrieveBattles { battles ->
            vBind.pbLoading.visibility = View.GONE

            if(battles == null){
                return@retrieveBattles
            }

            if(battles.isEmpty()){
                vBind.lblEmpty.visibility = View.VISIBLE
            }else{
                adapter = BattleAdapter(battles){ battle ->
                    val intent = Intent(this, BattleDetailsActivity::class.java)
                    intent.putExtra(BattleDetailsActivity.BATTLE_NAME, battle.name)
                    startActivity(intent)
                }
                vBind.rvBattles.adapter = adapter
            }
        }
    }

    private fun setupRecyclerView(){
        vBind.rvBattles.layoutManager = GridLayoutManager(this,2)
        vBind.rvBattles.itemAnimator = DefaultItemAnimator()
    }
}