package com.lessons.translatormvp.view.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.lessons.models.DataModel
import com.lessons.translatormvp.R
import com.lessons.translatormvp.databinding.ActivityMainBinding
import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.utils.isInternetAvailable
import com.lessons.translatormvp.utils.ui.convertMeaningsToString
import com.lessons.translatormvp.view.base.BaseActivity
import com.lessons.translatormvp.view.descriptionscreen.DescriptionActivity
import com.lessons.translatormvp.view.history.HistoryActivity
import com.lessons.translatormvp.view.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<AppState, MainInteractor>() {

    private lateinit var binding: ActivityMainBinding
    override lateinit var model: MainViewModel
    private val adapter: MainAdapter by lazy { MainAdapter(onListItemClickListener) }

    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                showInfo(data)
            }
        }

    private fun showInfo(data: DataModel) {
        startActivity(
            DescriptionActivity.getIntent(
                this@MainActivity, data.text!!,
                convertMeaningsToString(data.meanings), data.meanings?.let { it[0].imageUrl }
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initViews()
    }

    private fun setDataToAdapter(data: List<DataModel>) {
        adapter.setData(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history_menu, menu)
        initSearchInHistory(menu!!.findItem(R.id.action_search).actionView as SearchView)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initSearchInHistory(searchView: SearchView) {
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                p0?.let { model.getDataFromHistory(p0) }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        binding.mainActivityRecyclerview.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_history -> {
                startActivity(Intent(this, HistoryActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initViewModel() {
        if (binding.mainActivityRecyclerview.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        val viewModel: MainViewModel by viewModel()
        model = viewModel
        model.subscribe().observe(this@MainActivity, { renderData(it, ::setDataToAdapter) })
        model.ldDataModelInDb.observe(this, {
            renderData(it) { list ->
                if (list.isEmpty())
                    Toast.makeText(this, R.string.not_found_in_history, Toast.LENGTH_SHORT)
                        .show()
                else
                    showInfo(list[0])
            }

        })
    }

    private fun initViews() {
        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                isNetworkAvailable = isInternetAvailable(applicationContext)
                if (isNetworkAvailable) {
                    model.getData(p0 ?: "", isNetworkAvailable)
                } else {
                    showNoInternetConnectionDialog()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        binding.mainActivityRecyclerview.adapter = adapter
    }
}