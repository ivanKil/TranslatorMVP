package com.lessons.translatormvp.di.modules

import com.lessons.translatormvp.di.NAME_LOCAL
import com.lessons.translatormvp.di.NAME_REMOTE
import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.datasource.DataSource
import com.lessons.translatormvp.model.datasource.RetrofitImplementation
import com.lessons.translatormvp.model.datasource.RoomDataBaseImplementation
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.model.repository.RepositoryImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>):
            Repository<List<DataModel>> = RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>):
            Repository<List<DataModel>> = RepositoryImplementation(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> =
        RetrofitImplementation()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> =
        RoomDataBaseImplementation()
}

