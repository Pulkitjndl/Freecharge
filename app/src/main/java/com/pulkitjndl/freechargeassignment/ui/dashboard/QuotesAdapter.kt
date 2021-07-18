package com.pulkitjndl.freechargeassignment.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pulkitjndl.freechargeassignment.model.Quote

/**
 * Created by Pulkit Jindal
 * Date : 18/July/2021
 * Project : FreechargeAssignment
 */
class QuotesAdapter()
    : RecyclerView.Adapter<QuotesVH>(), QuotesVH.OnItemClickListener {

    private var quoteList: MutableList<Quote> = ArrayList()
    private lateinit var onQuoteItemClickListener: OnQuoteItemClickListener

    fun updateItems(list: MutableList<Quote>) {
        quoteList.clear()
        quoteList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesVH {
        val inflater = LayoutInflater.from(parent.context)
        return QuotesVH(inflater, parent)
    }

    override fun onBindViewHolder(holder: QuotesVH, position: Int) {
        val quote: Quote = quoteList[position]
        holder.bind(quote)
        holder.setOnItemClickListener(this)
    }
    override fun getItemCount(): Int = quoteList.size

    override fun onItemClicked(quote : Quote) {
        if (::onQuoteItemClickListener.isInitialized){
            onQuoteItemClickListener.onQuoteItemClicked(quote)
        }
    }

    interface OnQuoteItemClickListener{
        fun onQuoteItemClicked(quote: Quote)
    }

    fun setOnQuoteItemClickListener(onQuoteItemClickListener: OnQuoteItemClickListener){
        this.onQuoteItemClickListener=onQuoteItemClickListener
    }
}