package com.pulkitjndl.freechargeassignment.ui.dashboard.tagsfilter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pulkitjndl.freechargeassignment.R
import com.pulkitjndl.freechargeassignment.data.res_model.Tags

/**
 * Created by Pulkit Jindal
 * Date : 18/July/2021
 * Project : FreechargeAssignment
 */

class TagsFilterVH(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_tag, parent, false)) {

    private var mFilterCategory: TextView? = null
    private lateinit var onFilterItemClickListener: OnFilterItemClickListener

    init {
        mFilterCategory = itemView.findViewById(R.id.tv_filter_category)
    }

    @SuppressLint("SetTextI18n")
    fun bind(tag: Tags) {
        mFilterCategory?.text = tag.name

        itemView.setOnClickListener {
            onFilterItemClickListener.onFilterItemClick(tag)
        }
    }

    interface OnFilterItemClickListener {
        fun onFilterItemClick(tag: Tags)
    }

    fun setOnFilterItemClickListener(onItemClickListener: OnFilterItemClickListener) {
        this.onFilterItemClickListener = onItemClickListener
    }
}