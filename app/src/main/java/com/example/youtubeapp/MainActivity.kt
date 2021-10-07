package com.example.youtubeapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer

import androidx.annotation.NonNull
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback


import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView




class MainActivity : AppCompatActivity() {

    var id = ""
    private lateinit var cm: ConnectivityManager
    private lateinit var youTubePlayerView: YouTubePlayerView
    private lateinit var player: YouTubePlayer
    lateinit var rvMain: RecyclerView
    lateinit var adapteor: RVVideoAdapteor
    var videoInfoList = arrayListOf(
        VideoInfo("Ik4tMWQiSL4", "Orientation"),
        VideoInfo("6fvXhCffLaY", "Week1 Day1"),
        VideoInfo("fBA5j3c1D9c", "Week1 Day1 Stand Down"),
        VideoInfo("VZnLB-q55tw", "Week1 Day2"),
        VideoInfo("4ostmbmFL3Y", "Week1 Day2 Stand Down"),
        VideoInfo("pESK3Vp_pCY", "Week1 Day3"),
        VideoInfo("wUnueSGOGU4", "Week1 Day3 Stand Down"),
        VideoInfo("YC1uPCY3_-0", "Week1 Day4"),
        VideoInfo("IjB59Ud4K_c", "Week1 Day4 Stand Down"),
        VideoInfo("Hz94iHJla-E", "Week2 Day1"),
        VideoInfo("lO1sOV1E7XE", "Week2 Day1 Stand Down"),
        VideoInfo("dD9AahZ2V-E", "Week2 Day2"),
        VideoInfo("sCUC1tvsHFY", "Week2 Day2 Stand Down"),
        VideoInfo("TSfudeTk7sc", "Week2 Day3"),
        VideoInfo("EL9cU_Xzmbw", "Week2 Day3 Stand Down"),
        VideoInfo("4gEAS1jE3Qk", "Week2 Day4"),
        VideoInfo("jWvSaAqkGSI", "Week2 Day4 Stand Down"),
        VideoInfo("lINActKAOLg", "Week3 Day1"),
        VideoInfo("c6m9XkE4YVo", "Week3 Day2"),
        VideoInfo("dhUTSi0STjI", "Week3 Day2 Stand Down"),
        VideoInfo("QbcmPaJzINk", "Unconventional RecyclerView Android Unblocking"),
        VideoInfo("2bmWQPGYnrk", "Week3 Day3"),
        VideoInfo("JHnFYqz09KM", "Week3 Day3 Stand Down"),
        VideoInfo("4a6TdwIb7H4", "Week3 Day4"),
        VideoInfo("BmRWrb35gu8", "Week3 Day4 Stand Down"),
        VideoInfo("BmRWrb35gu8", "Week3 Day5"),
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youTubePlayerView = findViewById(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)

        // check network
        cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        if(activeNetwork?.isConnectedOrConnecting == true){
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    //https://github.com/AlminPiricDojo/KotlinYouTube/blob/master/app/src/main/java/com/example/kotlinyoutube/MainActivity.kt
                    super.onReady(youTubePlayer)
                    player = youTubePlayer
                    player.loadVideo(videoInfoList[0].id, 0f)

                    rvMain = findViewById(R.id.rvMain)
                    adapteor = RVVideoAdapteor(videoInfoList, player)
                    rvMain.adapter = adapteor
                    rvMain.layoutManager = GridLayoutManager(this@MainActivity, 3)
                }
            })
        }else{
            Toast.makeText(this@MainActivity, "Please Connect To Internet First", Toast.LENGTH_LONG).show()
        }



    }


}