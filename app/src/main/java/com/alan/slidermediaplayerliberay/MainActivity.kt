package com.alan.slidermediaplayerliberay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alan.slidermediaplayer.SliderMediaPlayer
import com.alan.slidermediaplayer.model.SliderMediaData
import com.alan.slidermediaplayer.util.TYPE_PHOTO
import com.alan.slidermediaplayer.util.TYPE_VIDEO

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smpViewer = findViewById<SliderMediaPlayer>(R.id.smpViewer)

        // get your data form api
        // and create a converter to convert your data
        val myData = listOf(
            SliderMediaData(
                url = "https://images.pexels.com/photos/460672/pexels-photo-460672.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                urlType = TYPE_PHOTO
            ),
            SliderMediaData(
                url = "https://images.pexels.com/photos/47547/squirrel-animal-cute-rodents-47547.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                urlType = TYPE_PHOTO
            ),
            SliderMediaData(
                url = "https://www.ebookfrenzy.com/android_book/movie.mp4",
                urlType = TYPE_VIDEO
            ),
            SliderMediaData(
                url = "https://images.pexels.com/photos/1661179/pexels-photo-1661179.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                urlType = TYPE_PHOTO
            ),
            SliderMediaData(
                url = "https://images.pexels.com/photos/326012/pexels-photo-326012.jpeg",
                urlType = TYPE_PHOTO
            ),
        )

        // set your data to fill screen
        smpViewer.setSliderMediaData(myData, this)
    }
}