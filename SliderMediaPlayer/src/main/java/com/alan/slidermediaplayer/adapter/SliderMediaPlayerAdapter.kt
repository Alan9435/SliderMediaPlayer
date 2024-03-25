package com.alan.slidermediaplayer.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alan.slidermediaplayer.fragment.PhotoFragment
import com.alan.slidermediaplayer.fragment.VideoFragment
import com.alan.slidermediaplayer.model.SliderMediaData
import com.alan.slidermediaplayer.util.TYPE_PHOTO
import com.alan.slidermediaplayer.util.TYPE_VIDEO

class SliderMediaPlayerAdapter(
    private val dataList: List<SliderMediaData>,
    private val placeholder: Int,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    private val TAG = SliderMediaPlayerAdapter::class.java.simpleName

    override fun getItemCount(): Int = dataList.size

    override fun createFragment(position: Int): Fragment {
        return when (dataList[position].urlType) {
            TYPE_PHOTO -> PhotoFragment.newInstance(dataList[position].url, placeholder)
            TYPE_VIDEO -> VideoFragment.newInstance(dataList[position].url)
            else -> {
                Log.e(TAG, "your urlType is wrong, please check it is TYPE_PHOTO or TYPE_VIDEO.")
                Fragment()
            }
        }
    }
}
