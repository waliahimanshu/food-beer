package com.waliahimanshu.demo.ui.home

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.waliahimanshu.demo.ui.R
import kotlinx.android.synthetic.main.recipe_item_list.view.*
import java.util.*

class RecipeEntryAdapter(private val dataSet: ArrayList<RecipeEntryModel>,
                         val onItemClickListener: OnItemClickListener? = null) :
        RecyclerView.Adapter<RecipeEntryAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, position: Int) {
        val recipeEntryModel = dataSet[position]

        Picasso.get()
                .load(recipeEntryModel.recipeImageUrl)
                .into(itemViewHolder.recipeImage, object : Callback {
                    override fun onSuccess() {
                    }
                    override fun onError(exception: Exception) {
                    }
                })


        recipeEntryModel.personModel.profileImageRes?.let {
            Picasso.get()
                    .load(it)
                    .fit()
                    .into(itemViewHolder.profileAvatar, object : Callback {
                        override fun onSuccess() {

                        }

                        override fun onError(exception: Exception) {

                        }
                    })
        }


        ViewCompat.setTransitionName(itemViewHolder.recipeImage, recipeEntryModel.recipeShortDescription)

        with(itemViewHolder.itemView) {
            setOnClickListener {
                onItemClickListener?.onItemClick(recipeEntryModel, itemViewHolder.recipeImage)
            }
        }

        itemViewHolder.recipeShortDesc.text = recipeEntryModel.recipeShortDescription
        itemViewHolder.profileName.text = recipeEntryModel.personModel.name
        itemViewHolder.profileSubText.text = recipeEntryModel.personModel.date
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal val profileAvatar: ImageView = view.profile_avatar
        internal val profileName: TextView = view.profile_tile
        internal val profileSubText: TextView = view.profile_subtitle_text

        internal val recipeImage: ImageView = view.profile_recipe_image
        internal val recipeShortDesc: TextView = view.recipe_short_discription
    }

    interface OnItemClickListener {
        fun onItemClick(item: RecipeEntryModel, view: ImageView)
    }
}
