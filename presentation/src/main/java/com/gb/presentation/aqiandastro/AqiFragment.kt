package com.gb.presentation.aqiandastro

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gb.domain.entities.AirQualityEntity
import com.gb.presentation.databinding.FragmentAqiBinding

class AqiFragment : Fragment() {

    private lateinit var binding: FragmentAqiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAqiBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initValues(arguments?.getSerializable(AIR_QUALITY) as? AirQualityEntity)
    }


    private fun initValues(airQualityEntity: AirQualityEntity?) {
        val progressDrawable = binding.airIndexBar.progressDrawable.mutate()
        initAirQualityStrings(
            airQualityEntity?.carbonMonoxide,
            airQualityEntity?.nitrogenDioxide,
            airQualityEntity?.ozone,
            airQualityEntity?.sulfurDioxide,
            airQualityEntity?.particulateMatter2_5
        )
        when (airQualityEntity?.useEpaIndex) {
            in 0..3 -> {
                binding.airIndexBar.progress = 80
                progressDrawable.colorFilter =
                    PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN)
                binding.ariQualityIndexDesc.text = "Air Quality is good"
            }

            in 4..5 -> {
                binding.airIndexBar.progress = 60
                progressDrawable.colorFilter =
                    PorterDuffColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN)
                binding.ariQualityIndexDesc.text = "Air Quality is Moderate"

            }

            in 6..7 -> {
                binding.airIndexBar.progress = 40
                progressDrawable.colorFilter =
                    PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
                binding.ariQualityIndexDesc.text = "Air Quality is bad"

            }

            in 8..10 -> {
                binding.airIndexBar.progress = 20
                progressDrawable.colorFilter =
                    PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
                binding.ariQualityIndexDesc.text = "Air Quality is very bad"
            }
        }

    }

    private fun initAirQualityStrings(carbonMonoxide: Double?,
                                      nitrogenDioxide: Double?,
                                      ozone: Double?,
                                      sulfurDioxide: Double?,
                                      particulateMatter2_5: Double?) {
        binding.apply {
            carboneMonoxide.text = "Carbone Monoxide: $carbonMonoxide"
            nitrogenMonoxide.text = "Nitrogen Monoxide: $nitrogenDioxide"
            ozonee.text = "Ozone: $ozone"
            sulfurDioxidetxt.text = "Sulfur Dioxide: $sulfurDioxide"
            particularMatter.text = "Particular Matter: $particulateMatter2_5"
        }
    }


    companion object {
        private const val AIR_QUALITY = "air_quality"

        @JvmStatic
        fun newInstance(airQualityEntity: AirQualityEntity) =
            AqiFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(AIR_QUALITY, airQualityEntity)
                }
            }
    }
}