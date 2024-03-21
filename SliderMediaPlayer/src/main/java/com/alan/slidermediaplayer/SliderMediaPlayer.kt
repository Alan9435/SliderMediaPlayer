package com.alan.slidermediaplayer

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.alan.slidermediaplayer.adapter.SliderMediaPlayerAdapter
import com.alan.slidermediaplayer.fragment.VideoFragment
import com.alan.slidermediaplayer.model.SliderMediaData
import com.alan.slidermediaplayer.util.RES_IS_EMPTY
import com.alan.slidermediaplayer.util.TYPE_VIDEO

class SliderMediaPlayer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {
    /**
     * Play automatically when you scroll to video page
     * */
    private var autoPlay = false

    private var offscreenPageLimit = 1

    private var vpMediaContainer: ViewPager2? = null

    private var mPlaceholder: Int = RES_IS_EMPTY

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        attrs?.let { mAttrs ->
            val typeArray = context.obtainStyledAttributes(mAttrs, R.styleable.SliderMediaPlayer)

            typeArray.apply {
                autoPlay = getBoolean(R.styleable.SliderMediaPlayer_autoPlay, false)
                offscreenPageLimit = getInt(R.styleable.SliderMediaPlayer_offscreenPageLimit, 1)
                mPlaceholder = getResourceId(R.styleable.SliderMediaPlayer_placeholder, RES_IS_EMPTY)
            }

            typeArray.recycle()
        }

        View.inflate(context, R.layout.view_slider_media_player, this)
        vpMediaContainer = findViewById(R.id.vpMediaContainer)
        vpMediaContainer?.offscreenPageLimit = offscreenPageLimit // set max hot loading
    }

    /**
     * type : required
     * Set a list of `SliderMediaData` objects as data to fill your screen.
     * */
    fun setSliderMediaData(dataList: List<SliderMediaData>, fragmentActivity: FragmentActivity) {
        vpMediaContainer?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (autoPlay) {
                    if (dataList[position].urlType == TYPE_VIDEO) {
                        val fragment = fragmentActivity.supportFragmentManager.findFragmentByTag("f$position")
                        if (fragment is VideoFragment) {
                            fragment.playVideo()
                        }
                    }
                }
            }
        })

        val myAdapter = SliderMediaPlayerAdapter(dataList = dataList, placeholder = mPlaceholder, fragmentActivity = fragmentActivity)
        vpMediaContainer?.adapter = myAdapter
    }

    /**
     * type : optional
     * page to Left
     * */
    fun goLeft() {
        vpMediaContainer?.currentItem = vpMediaContainer?.currentItem?.minus(1) ?: 0
    }

    /**
     * type : optional
     * page to right
     * */
    fun goRight() {
        vpMediaContainer?.currentItem = vpMediaContainer?.currentItem?.plus(1) ?: 0
    }

    /**
     * If you want Play automatically when you scroll to video page, you can set it to true
     * else set it to false
     * */
    fun setAutoPlay(autoPlay: Boolean) {
        this.autoPlay = autoPlay
    }

    /**
     * The offscreenPageLimit attribute is set as an integer value, with a default value of 1,
     * so the ViewPager only keeps the current page in memory.
     * However, if you have a lot of pages or complex pages that take up a lot of memory,
     * you can increase the offscreenPageLimit attribute to retain more pages in memory.
     * This can help to improve the performance of the app and reduce the amount of time
     * required to reload pages when the user navigates back to them.
     * */
    fun setOffscreenPageLimit(limitCount : Int) {
        offscreenPageLimit = limitCount
    }

    fun setPlaceholderForPhoto(res: Int) {
        mPlaceholder = res
    }

    /**
     * type : optional
     * Set the staring screen position
     * */
    fun setCurrentItem(current: Int) {
        vpMediaContainer?.doOnPreDraw {
            vpMediaContainer?.currentItem = current
        }
    }
}