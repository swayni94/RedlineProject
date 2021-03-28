package com.example.redline_project.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redline_project.databinding.ItemMainrecyclerviewBinding
import java.util.*

class MainRecyclerViewAdapter (val dogType: List<String>,
                               val listener: MainRecyclerViewListener) : RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val viewBinding:ItemMainrecyclerviewBinding) : RecyclerView.ViewHolder(viewBinding.root){

        fun bindViewHolder(dogType:String, number:Int) {
            val string = "$number - $dogType"
            viewBinding.itemTextview.text = string
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMainrecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(dogType.get(position).toUpperCase(Locale.ROOT), position+1)
        holder.itemView.setOnClickListener {
            listener.mainMainItemClicked(dogType.get(position))
        }
    }

    override fun getItemCount(): Int {
       return dogType.size
    }

}