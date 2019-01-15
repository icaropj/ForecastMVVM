package br.com.icaropinho.forecastmvvm

import android.app.Application
import br.com.icaropinho.forecastmvvm.data.db.ForecastDatabase
import br.com.icaropinho.forecastmvvm.data.network.*
import br.com.icaropinho.forecastmvvm.data.repository.ForecastRepository
import br.com.icaropinho.forecastmvvm.data.repository.ForecastRepositoryImpl
import br.com.icaropinho.forecastmvvm.ui.weather.current.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApp: Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApp))

        bind() from singleton { ForecastDatabase(instance()) } //instance returned from the androidXModule import
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance()) }
    }

}