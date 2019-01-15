package br.com.icaropinho.forecastmvvm.data.network.response

import br.com.icaropinho.forecastmvvm.data.db.entity.CurrentWeatherEntry
import br.com.icaropinho.forecastmvvm.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)