package com.gb.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.domain.entities.AirQualityEntity
import com.gb.domain.entities.AstroEntity
import com.gb.domain.entities.ForecastDayEntity
import com.gb.domain.entities.HourlyForecastEntity
import com.gb.presentation.R
import com.gb.presentation.adapters.AQIAndAstroVPAdapter
import com.gb.presentation.adapters.HourlyWeatherListAdapter
import com.gb.presentation.databinding.FragmentAstroBinding
import com.gb.presentation.databinding.FragmentDayWeatherDetailsBinding
import kotlin.math.round


class DayWeatherDetailsFragment : Fragment() {

    private lateinit var binding: FragmentDayWeatherDetailsBinding
    private var forecastEntity: ForecastDayEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forecastEntity = arguments?.getSerializable("forecastDayEntity") as ForecastDayEntity
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDayWeatherDetailsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initValues()
        setHourlyForecastAdapter(forecastEntity?.hour)
        setAQIAndAstro(forecastEntity?.astro)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initValues () {
        binding.apply {
            mainWeatherView.locationTitle =forecastEntity?.date
            mainWeatherView.description = forecastEntity?.day?.condition?.weatherDescription
            mainWeatherView.degree = "${forecastEntity?.day?.avgTempC}°"
            mainWeatherView.image = forecastEntity?.day?.condition?.imageUrl
        }
    }

    private fun setHourlyForecastAdapter(data: List<HourlyForecastEntity>?) {
        val adapter = HourlyWeatherListAdapter()
        binding.forecastDayHourlyWeather.adapter = adapter
        binding.forecastDayHourlyWeather.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter.submitList(data)
    }

    private fun setAQIAndAstro(astroEntity: AstroEntity?) {
        val viewPager = binding.viewPager
        val dotIndicator = binding.dotsIndicator
        viewPager.adapter = AQIAndAstroVPAdapter(
            listOf(
                AstroFragment.newInstance(astroEntity)
            ),
            fragmentActivity = requireActivity()
        )
        dotIndicator.attachTo(viewPager)
    }
}