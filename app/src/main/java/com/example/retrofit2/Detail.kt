package com.example.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.retrofit2.databinding.ActivityDetailBinding
import com.example.retrofit2.databinding.RecycleLayoutBinding

class Detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var images = intent.getStringExtra("IMAGES")
        var titles = intent.getStringExtra("TITLE")

        binding.title.text = "Species : ${titles}"

        Glide.with(this@Detail)
            .load(images)
            .fitCenter()
            .error(R.drawable.ic_launcher_background)
            .into(binding.gambarDetail)
    }
}