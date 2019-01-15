package br.com.icaropinho.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel;
import br.com.icaropinho.forecastmvvm.data.repository.ForecastRepository
import br.com.icaropinho.forecastmvvm.internal.UnitSystem
import br.com.icaropinho.forecastmvvm.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    private val unitSystem = UnitSystem.METRIC//TODO: get from settings

    private val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }

}
