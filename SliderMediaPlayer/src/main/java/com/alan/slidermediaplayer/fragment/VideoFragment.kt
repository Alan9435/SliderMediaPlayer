package com.alan.slidermediaplayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.alan.slidermediaplayer.databinding.FragmentVideoBinding

/**
 * this fragment only for video
 * */
class VideoFragment : Fragment() {

    companion object {
        private const val TAG_URL = "TAG_URL"

        fun newInstance(url: String): VideoFragment {
            return VideoFragment().apply {
                arguments = bundleOf(
                    TAG_URL to url
                )
            }
        }
    }

    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!
    private var mPlayer: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.initView()
    }

    private fun FragmentVideoBinding.initView() {
        val url = arguments?.getString(TAG_URL) ?: ""

        mPlayer = context?.let { ExoPlayer.Builder(it).build() }
        val mediaItem = MediaItem.fromUri(url)

        mPlayer?.apply {
            setMediaItem(mediaItem)
            prepare()
        }

        pvVideo.player = mPlayer
    }

    /**
     * pause your video
     * */
    private fun pauseVideo() {
        mPlayer?.pause()
    }

    /**
     * play your video
     * */
    fun playVideo() {
        mPlayer?.play()
    }

    /**
     * It's important to release the player when it's no longer needed,
     * so as to free up limited resources such as video decoders for use by other applications.
     * This can be done by calling ExoPlayer.release.
     * */
    private fun clearVideo() {
        mPlayer?.release()
        mPlayer = null
    }

    override fun onPause() {
        super.onPause()
        pauseVideo()
    }

    override fun onStop() {
        super.onStop()
        pauseVideo()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearVideo()
        binding.pvVideo.player = null
    }
}