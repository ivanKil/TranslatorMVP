package com.lessons.translatormvp.di

import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.datasource.RetrofitImplementation
import com.lessons.translatormvp.model.datasource.RoomDataBaseImplementation
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.model.repository.RepositoryImplementation
import com.lessons.translatormvp.view.main.MainInteractor
import com.lessons.translatormvp.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(RetrofitImplementation())
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(RoomDataBaseImplementation())
    }
}

val mainScreen = module {
    factory {
        MainInteractor(
            remoteRepository = get(named(NAME_REMOTE)),
            localRepository = get(named(NAME_LOCAL))
        )
    }
    viewModel { MainViewModel(interactor = get()) }
}
