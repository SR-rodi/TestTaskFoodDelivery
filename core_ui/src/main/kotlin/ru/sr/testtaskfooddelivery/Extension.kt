package ru.sr.testtaskfooddelivery

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(item: Any?) {
    Glide.with(this).load(item).into(this)
}