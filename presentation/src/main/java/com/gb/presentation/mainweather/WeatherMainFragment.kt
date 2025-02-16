package com.gb.presentation.mainweather


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.domain.common.Result
import com.gb.domain.entities.AirQualityEntity
import com.gb.domain.entities.AstroEntity
import com.gb.domain.entities.ForecastDayEntity
import com.gb.domain.entities.HourlyForecastEntity
import com.gb.presentation.adapters.AQIAndAstroVPAdapter
import com.gb.presentation.adapters.DaysForecastAdapter
import com.gb.presentation.adapters.HourlyWeatherListAdapter
import com.gb.presentation.aqiandastro.AqiFragment
import com.gb.presentation.aqiandastro.AstroFragment
import com.gb.presentation.common.hideKeyboard
import com.gb.presentation.databinding.FragmentWeatherMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt


class WeatherMainFragment : Fragment() {

    private lateinit var binding: FragmentWeatherMainBinding
    private val realTimeWeatherViewModel: RealTimeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeRealTimeWeather()
        setSearchListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setSearchListener() {
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                lifecycleScope.launch {
                    realTimeWeatherViewModel.getRealTimeWeather(p0.toString())
                    hideKeyboard()
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }
        })
    }

    private fun observeRealTimeWeather() {
        lifecycleScope.launch {
            realTimeWeatherViewModel.realTimeWeatherSharedFlow.collectLatest {
                when (it) {
                    is Result.Success -> {
                        binding.progressBar.isVisible = false
                        initHeaderView(
                            it.data.current.temperatureInCelsius.roundToInt().toString(),
                            it.data.current.condition.imageUrl,
                            it.data.location.name,
                            it.data.current.condition.weatherDescription,
                            it.data.current.feelsLikeInCelsius.roundToInt().toString()
                        )
                        setHourlyForecastAdapter(it.data.forecastEntity.forecastDayEntity[0].hour)
                        setDaysForecatsAdapter(it.data.forecastEntity.forecastDayEntity)
                        setAQIAndAstro(it.data.current.airQualityEntity, it.data.forecastEntity.forecastDayEntity.get(0).astro)
                    }

                    is Result.Error -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(requireContext(), "${it.errorMessage}", Toast.LENGTH_SHORT).show()
                    }

                    Result.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                }
            }
        }
    }

    private fun initHeaderView(
        temperatureInCelsius: String,
        imageUrl: String,
        name: String,
        description: String,
        feelsLike: String
    ) {
        binding.mainWeatherView.visibility = View.VISIBLE
        binding.mainWeatherView.image = imageUrl
        binding.mainWeatherView.locationTitle = name
        binding.mainWeatherView.description = description
        binding.mainWeatherView.degree = "$temperatureInCelsius°. Feels like $feelsLike°"
    }

    private fun setHourlyForecastAdapter(data: List<HourlyForecastEntity>) {
        val adapter = HourlyWeatherListAdapter()
        binding.hourlyWeather.adapter = adapter
        binding.hourlyWeather.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter.submitList(data)
    }

    private fun setDaysForecatsAdapter(data: List<ForecastDayEntity>) {
        val adapter = DaysForecastAdapter()
        binding.daysWeather.adapter = adapter
        binding.daysWeather.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.submitList(data)
    }

    private fun setAQIAndAstro(ariQualityIndex: AirQualityEntity, astroEntity: AstroEntity) {
        val viewPager = binding.viewPager
        val dotIndicator = binding.dotsIndicator
        viewPager.adapter = AQIAndAstroVPAdapter(
            listOf(AqiFragment.newInstance(airQualityEntity = ariQualityIndex), AstroFragment.newInstance(astroEntity)),
            fragmentActivity = requireActivity()
        )
        dotIndicator.attachTo(viewPager)
    }
}