package com.pulkitjndl.freechargeassignment.ui.dashboard

import android.annotation.SuppressLint
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pulkitjndl.freechargeassignment.R
import com.pulkitjndl.freechargeassignment.model.Quote
import com.pulkitjndl.freechargeassignment.utils.Extras
import kotlinx.android.synthetic.main.item_quote.view.*
import javax.inject.Inject

/**
 * Created by Pulkit Jindal
 * Date : 18/July/2021
 * Project : FreechargeAssignment
 */

class QuotesVH(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_quote, parent, false)) {


    private var onItemClickListener: OnItemClickListener?=null


    @SuppressLint("SetTextI18n")
    fun bind(quote: Quote) {

        itemView.content.text=quote.content
        itemView.author_name.text="~${quote.author}"
        itemView.layoutMain.setBackgroundColor(Extras.getRandomColor())

        itemView.setOnClickListener {
            onItemClickListener?.onItemClicked(quote)
        }
    }

    interface OnItemClickListener{
        fun onItemClicked(quote: Quote)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener=onItemClickListener
    }
}