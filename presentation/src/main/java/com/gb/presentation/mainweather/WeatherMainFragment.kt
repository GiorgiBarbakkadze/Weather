package com.gb.presentation.mainweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.domain.common.Result
import com.gb.domain.entities.ForecastDayEntity
import com.gb.domain.entities.HourlyForecastEntity
import com.gb.presentation.adapters.DaysForecastAdapter
import com.gb.presentation.adapters.HourlyWeatherListAdapter
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
    ): View? {
        binding = FragmentWeatherMainBinding.inflate(inflater)
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
                        initHeaderView(
                            it.data.current.temperatureInCelsius.roundToInt().toString(),
                            it.data.current.condition.imageUrl,
                            it.data.location.name,
                            it.data.current.condition.weatherDescription
                        )
                        setHourlyForecastAdapter(it.data.forecastEntity.forecastDayEntity[0].hour)
                        setDaysForecatsAdapter(it.data.forecastEntity.forecastDayEntity)
                    }

                    is Result.Error -> {
                        Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun initHeaderView(temperatureInCelsius: String, imageUrl: String, name: String, description: String) {
        binding.mainWeatherView.image = imageUrl
        binding.mainWeatherView.locationTitle = name
        binding.mainWeatherView.descriptionAndDegree = "$description $temperatureInCelsius°"
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

}