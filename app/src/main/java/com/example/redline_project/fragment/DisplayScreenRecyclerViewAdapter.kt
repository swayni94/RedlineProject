package com.example.redline_project.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redline_project.databinding.ItemDisplayscreenRecyclerviewBinding
import com.squareup.picasso.Picasso

class DisplayScreenRecyclerViewAdapter (val datas: List<String>,
                                        val listener:DisplayScreenRecyclerViewListener):RecyclerView.Adapter<DisplayScreenRecyclerViewAdapter.ViewHolder>(){

    class ViewHolder (private val viewBinding:ItemDisplayscreenRecyclerviewBinding) : RecyclerView.ViewHolder(viewBinding.root){
        fun bindViewHolder(link:String){
            Picasso.get().load(link).into(viewBinding.itemDisplayscreenImageview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDisplayscreenRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(datas[position])
        holder.itemView.setOnClickListener {
            listener.mainDisplayScreenItemClicked(datas[position])
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}