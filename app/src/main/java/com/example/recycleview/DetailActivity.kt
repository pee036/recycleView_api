package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.recycleview.databinding.ActivityDetailBinding
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.models.Data



class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val  intent = intent.getParcelableExtra<Data>("youtube")
        intent?.let {
            binding.textDetail.setText(it.title)
            Glide.with(binding.imageDetail).load(it.youtubeImage).into(binding.imageDetail)
            binding.textSubTitle.setText(it.subtitle)
        }
    }
}