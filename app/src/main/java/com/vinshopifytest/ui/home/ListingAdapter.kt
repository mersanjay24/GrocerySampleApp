package com.vinshopifytest.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vinshopifytest.R
import com.vinshopifytest.databinding.RowFeaturedBinding

class ListingAdapter(
    private val data: List<Featured>?
) :
    RecyclerView.Adapter<ListingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: RowFeaturedBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_featured,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = data?.get(position)
        holder.binding.executePendingBindings()

    }


    override fun getItemCount(): Int {
        return data?.size!!
    }

    inner class ViewHolder(var binding: RowFeaturedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvOutOfStock: TextView


        init {
            tvOutOfStock = binding.root.findViewById<View>(R.id.tvOutOfStock) as TextView
        }
    }
}
