
package com.pulkitjndl.freechargeassignment.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.pulkitjndl.freechargeassignment.MainApplication
import com.pulkitjndl.freechargeassignment.R
import com.pulkitjndl.freechargeassignment.databinding.ActivityDashboardBinding
import com.pulkitjndl.freechargeassignment.databinding.ActivityDetailBinding
import com.pulkitjndl.freechargeassignment.model.Quote
import com.pulkitjndl.freechargeassignment.ui.Router
import com.pulkitjndl.freechargeassignment.ui.dashboard.DashboardViewModel
import com.pulkitjndl.freechargeassignment.ui.dashboard.QuotesAdapter
import com.pulkitjndl.freechargeassignment.ui.dashboard.tagsfilter.TagFilterAdapter
import com.pulkitjndl.freechargeassignment.utils.LayoutUtils
import com.pulkitjndl.freechargeassignment.utils.viewModelProvider
import dagger.internal.DoubleCheck.lazy
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    private val appComponents =  MainApplication.appComponents


    private val TAG = "DetailActivity"

    private lateinit var binding: ActivityDetailBinding

    @Inject
    lateinit var router: Router

    private var quote:Quote?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        appComponents.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        quote=intent.extras?.getSerializable(router.QUOTE_DATA) as Quote
        binding.quote.text=quote!!.content
        binding.author.text = quote!!.author


    }

}