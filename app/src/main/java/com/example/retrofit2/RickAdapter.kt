package com.example.retrofit2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit2.Model.dataList

class RickAdapter(val dataRick: List<dataList>?): RecyclerView.Adapter<RickAdapter.MyViewHolder>(){
    class MyViewHolder (view: View):RecyclerView.ViewHolder(view){
        val imageMovie = view.findViewById<ImageView>(R.id.gambar_url)
        val titleMovie = view.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataRick!=null){
            return dataRick.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleMovie.text= dataRick?.get(position)?.title

        Glide.with(holder.imageMovie)
            .load(dataRick?.get(position)?.image)
            .fitCenter()
            .error(R.drawable.ic_launcher_background)
            .into(holder.imageMovie)

        holder.itemView.setOnClickListener{
            val intentToDetail = Intent(holder.itemView.context, Detail::class.java)
            intentToDetail.putExtra("IMAGES", dataRick?.get(position)?.image)
            intentToDetail.putExtra("TITLE", dataRick?.get(position)?.title)
            holder.itemView.context.startActivity(intentToDetail)
        }
    }

}