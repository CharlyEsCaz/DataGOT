package mx.com.charlyescaz.datagot.ui.places.continents

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityContinentsBinding
import mx.com.charlyescaz.datagot.interactors.ContinentInteractor
import mx.com.charlyescaz.datagot.ui.CustomActivity
import mx.com.charlyescaz.datagot.ui.places.continents.adapter.ContinentAdapter

class ContinentActivity: CustomActivity() {

    private lateinit var vBind: ActivityContinentsBinding
    private lateinit var adapter: ContinentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_continents)
        super.setupBackButton(vBind.iToolbar.toolbar, R.color.secondary)

        setupRecyclerView()
        setupAdapter()
    }


    private fun setupAdapter(){
        vBind.pbLoading.visibility = View.VISIBLE
        vBind.lblEmpty.visibility = View.GONE

        ContinentInteractor.retrieveContinents { continents ->
            vBind.pbLoading.visibility = View.GONE

            if(continents == null){
                return@retrieveContinents
            }

            if(continents.isEmpty()){
                vBind.lblEmpty.visibility = View.VISIBLE
            }else{
                adapter = ContinentAdapter(continents, this)
                vBind.rvContinents.adapter = adapter
            }
        }
    }

    private fun setupRecyclerView(){
        vBind.rvContinents.layoutManager = LinearLayoutManager(this)
        vBind.rvContinents.itemAnimator = DefaultItemAnimator()
    }
}