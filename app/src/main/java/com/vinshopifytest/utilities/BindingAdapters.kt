package com.vinshopifytest.utilities

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.vinshopifytest.R

class DataBindingUtils {
    companion object {

        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(view: View, path: String?) {
            val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide.with(view.context)
                .load(path)
                .apply(requestOptions)
                .thumbnail(0.1f)
                .placeholder(R.drawable.ic_android_black_24dp)
                .into((view as ImageView))
        }

        @JvmStatic
        @BindingAdapter("visibleGone")
        fun visibleGone(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}