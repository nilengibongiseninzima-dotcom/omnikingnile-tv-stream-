package com.omnikingnile.tvstream

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer
    private lateinit var playerView: StyledPlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerView = findViewById(R.id.playerView)
        val urlInput = findViewById<EditText>(R.id.urlInput)
        val playBtn = findViewById<Button>(R.id.playBtn)

        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        playBtn.setOnClickListener {
            val url = urlInput.text.toString()
            val mediaItem = MediaItem.fromUri(Uri.parse(url))
            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
