package com.lessons.translatormvp.di

import androidx.room.Room
import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.datasource.DataSource
import com.lessons.translatormvp.model.datasource.DataSourceLocal
import com.lessons.translatormvp.model.datasource.RetrofitImplementation
import com.lessons.translatormvp.model.datasource.RoomDataBaseImplementation
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.model.repository.RepositoryImplementation
import com.lessons.translatormvp.model.repository.RepositoryImplementationLocal
import com.lessons.translatormvp.model.repository.RepositoryLocal
import com.lessons.translatormvp.room.HistoryDataBase
import com.lessons.translatormvp.view.history.HistoryInteractor
import com.lessons.translatormvp.view.history.HistoryViewModel
import com.lessons.translatormvp.view.main.MainInteractor
import com.lessons.translatormvp.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, DB_NAME).build() }
    single { get<HistoryDataBase>().historyDao() }
    single<DataSource<List<DataModel>>> { RetrofitImplementation() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(dataSource = get()) }
    single<DataSourceLocal<List<DataModel>>> { RoomDataBaseImplementation(historyDao = get()) }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(dataSource = get())
    }
}

val mainScreen = module {
    factory { MainInteractor(repositoryRemote = get(), repositoryLocal = get()) }
    viewModel { MainViewModel(interactor = get()) }
}

val historyScreen = module {
    factory { HistoryInteractor(repositoryRemote = get(), repositoryLocal = get()) }
    viewModel { HistoryViewModel(interactor = get()) }
}
