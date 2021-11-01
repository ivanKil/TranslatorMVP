package com.lessons.translatormvp.view.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.lessons.translatormvp.R
import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.utils.isInternetAvailable
import com.lessons.translatormvp.utils.ui.AlertDialogFragment

abstract class BaseActivity<T : AppState> : AppCompatActivity() {
    protected var isNetworkAvailable: Boolean = false

    abstract val model: BaseViewModel<T>
    abstract fun renderData(appState: T)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        isNetworkAvailable = isInternetAvailable(applicationContext)
    }

    override fun onResume() {
        super.onResume()
        isNetworkAvailable = isInternetAvailable(applicationContext)
        if (!isNetworkAvailable && isDialogNull()) {
            showNoInternetConnectionDialog()
        }
    }

    protected fun showNoInternetConnectionDialog() {
        showAlertDialog(
            getString(R.string.dialog_title_device_is_offline),
            getString(R.string.dialog_message_device_is_offline)
        )
    }

    protected fun showAlertDialog(title: String?, message: String?) {
        AlertDialogFragment.newInstance(title, message)
            .show(supportFragmentManager, DIALOG_FRAGMENT_TAG)
    }

    private fun isDialogNull(): Boolean {
        return supportFragmentManager.findFragmentByTag(DIALOG_FRAGMENT_TAG) == null
    }

    companion object {
        private const val DIALOG_FRAGMENT_TAG = "74a54328-5d62-46bf-ab6b-cbf5d8c79522"
    }
}
