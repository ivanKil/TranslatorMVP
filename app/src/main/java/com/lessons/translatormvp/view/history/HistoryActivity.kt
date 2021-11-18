package com.lessons.translatormvp.view.history

import android.os.Bundle
import androidx.lifecycle.Observer
import com.lessons.models.DataModel
import com.lessons.translatormvp.databinding.ActivityHistoryBinding
import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.view.base.BaseActivity
import org.koin.androidx.scope.createScope
import org.koin.core.component.KoinScopeComponent
import org.koin.core.scope.Scope

class HistoryActivity : BaseActivity<AppState, HistoryInteractor>(), KoinScopeComponent {
    override val scope: Scope by lazy { createScope(this) }
    private lateinit var binding: ActivityHistoryBinding
    override val model: HistoryViewModel by scope.inject()
    private val adapter: HistoryAdapter by lazy { HistoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniViewModel()
        initViews()
    }

    override fun onResume() {
        super.onResume()
        model.getData("", false)
    }

    private fun setDataToAdapter(data: List<DataModel>) {
        adapter.setData(data)
    }

    private fun iniViewModel() {
        if (binding.historyActivityRecyclerview.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        model.subscribe().observe(
            this@HistoryActivity,
            Observer<AppState> { renderData(it, ::setDataToAdapter) })
    }

    private fun initViews() {
        binding.historyActivityRecyclerview.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.close()
    }
}
