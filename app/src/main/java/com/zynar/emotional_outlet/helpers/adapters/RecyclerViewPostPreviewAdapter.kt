package com.zynar.emotional_outlet.helpers.adapters

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.zynar.emotional_outlet.R
import com.zynar.emotional_outlet.databinding.ItemPostPreviewBinding
import com.zynar.emotional_outlet.ui.home.Post

class RecyclerViewPostPreviewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerViewPostPreviewAdapter.ViewHolder>() {

    var postList: List<Post> ?= null

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(item: List<Post>) {
        postList = item
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList!!)
    }

    override fun getItemCount(): Int {
        return postList!!.size
    }

    class ViewHolder(private val binding: ItemPostPreviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data:List<Post>) {
            val post = data[adapterPosition]
            binding.tvUserNickName.text = post.userNickname
            binding.tvUserTag.text = post.userTag
            binding.tvContent.text = post.content
        }
    }
}