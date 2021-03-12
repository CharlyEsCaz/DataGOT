package mx.com.charlyescaz.datagot.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("visible")
fun View.bindVisible(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("loadUrl")
fun ImageView.loadUrl(url: String?) {
    if (url != null && url.isNotEmpty()) {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}