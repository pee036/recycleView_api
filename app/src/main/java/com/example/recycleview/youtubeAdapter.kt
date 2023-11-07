package com.example.recycleview

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.bumptech.glide.Glide
import com.example.recycleview.databinding.ActivityDetailBinding
import com.example.recycleview.databinding.BoxDetailBinding
import com.example.recycleview.models.AllghostRadioList
import com.example.recycleview.models.Data
import com.squareup.picasso.Picasso

class youtubeAdapter(private val AllghostRadioList: List<Data>) : RecyclerView.Adapter<youtubeAdapter.ViewHolder>(){

    var onItemClick : ((Data) -> Unit)? = null

    class ViewHolder(val binding: BoxDetailBinding) : RecyclerView.ViewHolder(binding.root){
//        val imageView : ImageView = itemView.findViewById(R.id.imageView)
//        val textView : TextView = itemView.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BoxDetailBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return AllghostRadioList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  currentItem = AllghostRadioList[position]
        holder.binding.apply {
            Glide.with(this.imageView).load(currentItem.youtubeImage).into(imageView)
            textView.text = currentItem.title
            textView2.text = currentItem.comments.size.toString()
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }

}