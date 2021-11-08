package com.lessons.translatormvp.di.modules

import com.lessons.translatormvp.di.NAME_LOCAL
import com.lessons.translatormvp.di.NAME_REMOTE
import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.view.main.MainInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}