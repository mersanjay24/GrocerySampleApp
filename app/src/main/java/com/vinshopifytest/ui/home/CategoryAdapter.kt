package com.vinshopifytest.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vinshopifytest.R
import com.vinshopifytest.databinding.RowCategoryBinding
import com.vinshopifytest.databinding.RowFeaturedBinding

class CategoryAdapter(
    private val data: List<Category>?
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: RowCategoryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_category,
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

    inner class ViewHolder(var binding: RowCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}
