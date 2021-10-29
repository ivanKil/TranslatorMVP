package com.lessons.translatormvp.view.main

import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.model.datasource.DataSourceLocal
import com.lessons.translatormvp.model.datasource.DataSourceRemote
import com.lessons.translatormvp.model.repository.RepositoryImplementation
import com.lessons.translatormvp.presenter.Interactor
import com.lessons.translatormvp.presenter.Presenter
import com.lessons.translatormvp.rx.SchedulerProvider
import com.lessons.translatormvp.view.base.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class MainPresenterImpl<T : AppState, V : View>(
    private val interactor: Interactor<AppState> = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    ),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : Presenter<T, V> {
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}
