package mx.com.charlyescaz.datagot.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import mx.com.charlyescaz.datagot.R
import mx.com.charlyescaz.datagot.utils.ToolbarUtils

open class CustomActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setupBackButton(toolbar: Toolbar, color: Int = R.color.secondary) {
        ToolbarUtils.setupBackBtn(toolbar, this, color)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true;
    }

}