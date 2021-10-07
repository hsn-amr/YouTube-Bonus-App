package com.example.youtubeapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class RVVideoAdapteor(var videoInfoList: ArrayList<VideoInfo>, val player: YouTubePlayer):RecyclerView.Adapter<RVVideoAdapteor.ItemViewHolder>() {
    class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val videoInfo = videoInfoList[position]

        holder.itemView.apply {
            rvVideoSelectButton.text = videoInfo.title
            rvVideoSelectButton.setOnClickListener {
                player.loadVideo(videoInfo.id, 0f)
            }
        }
    }

    override fun getItemCount() = videoInfoList.size
}