package com.zynar.emotional_outlet.helpers.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.zynar.emotional_outlet.R

class RecyclerViewPostPreviewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerViewPostPreviewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_preview, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 레이아웃 값 설정
    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}