package br.com.icaropinho.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import br.com.icaropinho.forecastmvvm.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {

    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

}