package br.com.icaropinho.forecastmvvm.data.network

import androidx.lifecycle.LiveData
import br.com.icaropinho.forecastmvvm.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadedCurrentWeahter: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(location: String, languageCode: String)

}