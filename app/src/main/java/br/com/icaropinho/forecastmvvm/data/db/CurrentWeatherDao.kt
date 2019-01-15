package br.com.icaropinho.forecastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.icaropinho.forecastmvvm.data.db.entity.CURRENT_WEATHER_ID
import br.com.icaropinho.forecastmvvm.data.db.entity.CurrentWeatherEntry
import br.com.icaropinho.forecastmvvm.data.db.unitlocalized.ImperialCurrentWeatherEntry
import br.com.icaropinho.forecastmvvm.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {

    //Update or insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>

}