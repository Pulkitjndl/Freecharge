package com.pulkitjndl.freechargeassignment.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pulkitjndl.freechargeassignment.MainApplication
import com.pulkitjndl.freechargeassignment.R
import com.pulkitjndl.freechargeassignment.data.res_model.Tags
import com.pulkitjndl.freechargeassignment.databinding.ActivityDashboardBinding
import com.pulkitjndl.freechargeassignment.model.Quote
import com.pulkitjndl.freechargeassignment.ui.Router
import com.pulkitjndl.freechargeassignment.ui.dashboard.tagsfilter.TagFilterAdapter
import com.pulkitjndl.freechargeassignment.utils.*
import javax.inject.Inject

class DashboardActivity : AppCompatActivity(),QuotesAdapter.OnQuoteItemClickListener,TagFilterAdapter.OnTagClickedListener {

    private val appComponents by lazy { MainApplication.appComponents }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val TAG = "Dashboard_Activity"

    private lateinit var binding: ActivityDashboardBinding

    private fun getViewModel(): DashboardViewModel {
        return viewModelProvider(viewModelFactory)
    }

    @Inject
    lateinit var router: Router

    private val DEFAULT_TAKE = 10 //limit
    private val DEFAULT_SKIP = 0
    private var take = 0
    private var skip = 0
    private var allLoaded = false
    private var isViewMore = false

    private var adapter:QuotesAdapter?=null
    private var filterAdapter: TagFilterAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        appComponents.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)


        initViews()
        initObservers()
    }

    private fun initViews() {
        binding.rvQuotes.layoutManager=LayoutUtils.getVerticalLayoutManager(this)
        adapter= QuotesAdapter()
        binding.rvQuotes.adapter=adapter
        adapter?.setOnQuoteItemClickListener(this)

        binding.rvTags.layoutManager =
            LayoutUtils.getHorizontalLayoutManager(this)
        filterAdapter= TagFilterAdapter()
        binding.rvTags.adapter=filterAdapter
        filterAdapter?.setOnTagItemClickListener(this)

        getViewModel().getAllQuotes(DEFAULT_TAKE,DEFAULT_SKIP)
        getViewModel().getAllTags()
    }

    private fun initObservers() {

        getViewModel().resultAllQuotes.observe(this, Observer { data ->
            data?.let {
                populateQuotesRecyclerView(data.results as ArrayList)
            }
        })

        getViewModel().errortAllQuotes.observe(this, Observer {
            Log.d(TAG, "initObservers: $it")
        })
        getViewModel().loadingAllQuotes.observe(this, Observer { showLoading ->
            binding.progressBar.apply {
                if (showLoading) this.show() else this.hide()
            }
        })

        // Observing Tags API

        getViewModel().resultAllTags.observe(this, Observer { data ->
            data?.let {
                populateTagsRecyclerView(data)
            }
        })

        getViewModel().errortAllTags.observe(this, Observer {
            Log.d(TAG, "initObservers: $it")
        })

    }

    private fun populateQuotesRecyclerView(quotes: ArrayList<Quote>) {
        adapter?.updateItems(quotes)
    }

    private fun populateTagsRecyclerView(tagsList: ArrayList<Tags>) {
        filterAdapter?.updateItems(tagsList)
    }

    override fun onQuoteItemClicked(quote: Quote) {
        router.showQuoteDetailPage(this,quote)
    }

    override fun onTagClickedListener(tag: Tags) {
        getViewModel().getAllQuotes(DEFAULT_TAKE,DEFAULT_SKIP,tag.name)
    }

}