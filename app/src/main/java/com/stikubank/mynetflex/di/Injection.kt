package com.stikubank.mynetflex.di

import androidx.room.Room
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.LocalDataSource
import com.stikubank.mynetflex.data.source.local.room.NetflexDatabase
import com.stikubank.mynetflex.data.source.remote.RemoteDataSource
import com.stikubank.mynetflex.viewmodel.FavMoviesViewModel
import com.stikubank.mynetflex.viewmodel.FavShowsViewModel
import com.stikubank.mynetflex.utils.AppExecutors
import com.stikubank.mynetflex.utils.JsonHelper
import com.stikubank.mynetflex.viewmodel.DetailViewModel
import com.stikubank.mynetflex.viewmodel.MoviesViewModel
import com.stikubank.mynetflex.viewmodel.ShowsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val jsonHelperModule = module {
    factory { JsonHelper(get()) }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single { LocalDataSource(get()) }
    factory { AppExecutors() }
    single { NetflexRepository(get(), get(), get()) }
}

val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }
    viewModel { ShowsViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { FavMoviesViewModel (get()) }
    viewModel { FavShowsViewModel (get()) }
}

val databaseModule = module {
    factory { get<NetflexDatabase>().netflexDao() }

    single {
        Room.databaseBuilder(
            androidContext(),
            NetflexDatabase::class.java,
            "Netflex.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}
