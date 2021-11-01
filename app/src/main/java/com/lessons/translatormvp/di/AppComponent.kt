package com.lessons.translatormvp.di

import android.app.Application
import com.lessons.translatormvp.App
import com.lessons.translatormvp.di.modules.ActivityModule
import com.lessons.translatormvp.di.modules.InteractorModule
import com.lessons.translatormvp.di.modules.RepositoryModule
import com.lessons.translatormvp.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [InteractorModule::class, RepositoryModule::class, ViewModelModule::class,
        ActivityModule::class, AndroidSupportInjectionModule::class]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(englishVocabularyApp: App)
}

