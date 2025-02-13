package com.gb.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.gb.presentation.common.loadImage
import com.gb.presentation.databinding.MainHeaderItemBinding

class CurrentWeatherView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    private var binding: MainHeaderItemBinding =
        MainHeaderItemBinding.inflate(LayoutInflater.from(context), this, true)

    var image: String?
            = null
        set(value) {
            field = value
            value?.let {
                binding.weatherIcon.loadImage(context, field)
            }
        }
    var locationTitle: String? = null
        set(value) {
            field = value
            value?.let {
                binding.locationTitle.text = field
            }
        }

    var descriptionAndDegree: String? = null
        set(value) {
            field = value
            value?.let {
                binding.descriptionAndDegree.text = field
            }
        }

    init {
//        binding.root.setBackgroundResource(R.drawable.round_corner_shape)
    }
}