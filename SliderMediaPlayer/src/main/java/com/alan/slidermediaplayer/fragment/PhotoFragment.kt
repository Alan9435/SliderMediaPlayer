package com.alan.slidermediaplayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.alan.slidermediaplayer.databinding.FragmentPhotoBinding
import com.alan.slidermediaplayer.util.RES_IS_EMPTY
import com.alan.slidermediaplayer.util.loadUrl

/**
 * this fragment only for photo
 * */
class PhotoFragment : Fragment() {

    companion object {
        private const val TAG_URL = "TAG_URL"
        private const val TAG_IMAGE_PLACEHOLDER = "TAG_IMAGE_PLACEHOLDER"

        fun newInstance(url: String, imagePlaceholder: Int = RES_IS_EMPTY): PhotoFragment {
            return PhotoFragment().apply {
                arguments = bundleOf(
                    TAG_URL to url,
                    TAG_IMAGE_PLACEHOLDER to imagePlaceholder
                )
            }
        }
    }

    private var _binding: FragmentPhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.initView()
    }

    private fun FragmentPhotoBinding.initView() {
        val url = arguments?.getString(TAG_URL) ?: ""
        val placeholder = arguments?.getInt(TAG_IMAGE_PLACEHOLDER) ?: RES_IS_EMPTY

        if (placeholder != RES_IS_EMPTY) {
            ivPhoto.loadUrl(url = url, placeholder = placeholder)
        } else {
            ivPhoto.loadUrl(url = url)
        }
    }
}