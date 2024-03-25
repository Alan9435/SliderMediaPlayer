package com.alan.slidermediaplayer.util

import android.widget.ImageView
import com.alan.slidermediaplayer.R
import com.bumptech.glide.Glide


fun ImageView.loadUrl(url: String, placeholder: Int = R.drawable.loading) {
    if (url.isEmpty()) {
        setImageResource(R.drawable.loading)
    } else {
        Glide.with(this)
            .load(url)
            .placeholder(placeholder)
            .override(this.width, this.height)
            .into(this)
    }
}