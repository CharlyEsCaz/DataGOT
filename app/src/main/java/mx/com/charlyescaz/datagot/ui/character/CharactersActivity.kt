package mx.com.charlyescaz.datagot.ui.character

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityCharactersBinding
import mx.com.charlyescaz.datagot.databinding.ActivityHomeBinding
import mx.com.charlyescaz.datagot.interactors.CharacterInteractor
import mx.com.charlyescaz.datagot.ui.CustomActivity
import mx.com.charlyescaz.datagot.ui.character.adapter.CharacterAdapter

class CharactersActivity: CustomActivity() {

    private lateinit var vBind: ActivityCharactersBinding
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_characters)
        super.setupBackButton(vBind.iToolbar.toolbar, R.color.secondary)
        setupRecyclerView()
        setupAdapter()
    }

    private fun setupAdapter(){
        vBind.pbLoading.visibility = View.VISIBLE
        vBind.lblEmpty.visibility = View.GONE

        CharacterInteractor.retrieveCharacters { characters ->
            vBind.pbLoading.visibility = View.GONE

            if(characters == null){
                return@retrieveCharacters
            }

            if(characters.isEmpty()){
                vBind.lblEmpty.visibility = View.VISIBLE
            }else{
                adapter = CharacterAdapter(characters){ character ->
                    val intent = Intent(this, CharacterDetailsActivity::class.java)
                    intent.putExtra(CharacterDetailsActivity.CHARACTER_NAME, character.name)
                    startActivity(intent)
                }
                vBind.rvCharacters.adapter = adapter
            }
        }
    }

    private fun setupRecyclerView(){
        vBind.rvCharacters.layoutManager = LinearLayoutManager(this)
        vBind.rvCharacters.itemAnimator = DefaultItemAnimator()
    }
}