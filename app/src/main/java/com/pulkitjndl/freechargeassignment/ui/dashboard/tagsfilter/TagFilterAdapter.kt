package com.pulkitjndl.freechargeassignment.ui.dashboard.tagsfilter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pulkitjndl.freechargeassignment.R
import com.pulkitjndl.freechargeassignment.data.res_model.Tags
import com.pulkitjndl.freechargeassignment.model.Quote
import kotlinx.android.synthetic.main.item_tag.view.*
import java.util.*

/**
 * Created by Pulkit Jindal
 * Date : 18/July/2021
 * Project : FreechargeAssignment
 */
class TagFilterAdapter()
    : RecyclerView.Adapter<TagsFilterVH>(),
    TagsFilterVH.OnFilterItemClickListener {

    private var lastFilterSelectedPosition:String? = null
    private var tagsList: MutableList<Tags> = ArrayList()
    private lateinit var onTagClickedListener: OnTagClickedListener

    fun updateItems(list: MutableList<Tags>) {
        tagsList.clear()
        tagsList.addAll(list)
        notifyDataSetChanged()
    }

    fun setSelectedItem(itemId:String){
        lastFilterSelectedPosition=itemId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsFilterVH {
        val inflater = LayoutInflater.from(parent.context)
        return TagsFilterVH(inflater, parent)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: TagsFilterVH, position: Int) {
        val tag : Tags = tagsList[position]
        holder.bind(tag)
        holder.setOnFilterItemClickListener(this)

        if(lastFilterSelectedPosition==tag.id){
            holder.itemView.item_filter.setBackgroundResource(R.drawable.bg_rounded_black)
            holder.itemView.tv_filter_category.setTextColor(Color.WHITE)
        }else{
            holder.itemView.item_filter.setBackgroundResource(R.drawable.bg_rounded_primary_grey)
            holder.itemView.tv_filter_category.setTextColor(R.color.black)
        }
    }

    override fun getItemCount(): Int = tagsList.size

    override fun onFilterItemClick(tags: Tags) {
        if(::onTagClickedListener.isInitialized)
            onTagClickedListener.onTagClickedListener(tags)
        lastFilterSelectedPosition = tags.id
        notifyDataSetChanged()
    }

    interface OnTagClickedListener{
        fun onTagClickedListener(tag: Tags)
    }
    fun setOnTagItemClickListener(onTagClickedListener: OnTagClickedListener){
        this.onTagClickedListener=onTagClickedListener
    }

}