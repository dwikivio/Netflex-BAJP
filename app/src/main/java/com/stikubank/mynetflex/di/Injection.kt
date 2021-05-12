package com.stikubank.mynetflex.di

import android.content.Context
import com.stikubank.mynetflex.data.source.NetflexRepository
import com.stikubank.mynetflex.data.source.remote.RemoteDataSource
import com.stikubank.mynetflex.utils.JsonHelper
import com.stikubank.mynetflex.viewmodel.DetailViewModel
import com.stikubank.mynetflex.viewmodel.MoviesViewModel
import com.stikubank.mynetflex.viewmodel.ShowsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Injection {
    fun provideRepository(context: Context): NetflexRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return NetflexRepository.getInstance(remoteDataSource)
    }
}

val jsonHelperModule = module {
    factory { JsonHelper(get()) }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single { NetflexRepository(get()) }
}

val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }
    viewModel { ShowsViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}