package mx.com.charlyescaz.datagot.ui

import android.content.Intent
import android.net.sip.SipErrorCode.TIME_OUT
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.databinding.ActivityLoadingBinding
import mx.com.charlyescaz.datagot.ui.home.HomeActivity


class LoadingActivity: CustomActivity() {

    private lateinit var vBind: ActivityLoadingBinding
    private val timeOut = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vBind = DataBindingUtil.setContentView(this, R.layout.activity_loading)
        setupDelay()
    }

    fun setupDelay(){
        Handler().postDelayed(Runnable {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            finish()
        }, timeOut)
    }
}