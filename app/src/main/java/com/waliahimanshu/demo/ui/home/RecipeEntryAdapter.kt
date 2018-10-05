package com.waliahimanshu.demo.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.waliahimanshu.demo.ui.R
import kotlinx.android.synthetic.main.recipe_item_list.view.*
import java.util.*

class RecipeEntryAdapter(private val dataSet: ArrayList<RecipeEntryModel>) :
        RecyclerView.Adapter<RecipeEntryAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, position: Int) {
        itemViewHolder.hello.text = dataSet[position].title
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal val hello: TextView = view.supporting_text
    }
}
