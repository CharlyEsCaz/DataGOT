package mx.com.charlyescaz.datagot.utils;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import mx.com.charlyescaz.datagot.R;


public class ToolbarUtils {

    /**
     * @param toolbar
     * @param mActivity
     */
    public static void setupBackBtn(Toolbar toolbar,
                                    AppCompatActivity mActivity,
                                    int colorId
    ) {
        mActivity.setSupportActionBar(toolbar);

        ActionBar actionBar = mActivity.getSupportActionBar();

        if (actionBar != null) {
            Drawable drawable = ContextCompat.getDrawable(mActivity, R.drawable.ic_back);
            drawable.setColorFilter(ContextCompat.getColor(mActivity, colorId), PorterDuff.Mode.SRC_ATOP);
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public static void disabledBackBtn(Toolbar toolbar,
                                       AppCompatActivity mActivity) {
        mActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = mActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }
}
