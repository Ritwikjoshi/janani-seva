package com.janni.botlabs.jananiseva;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import static com.google.android.youtube.player.YouTubePlayer.*;

public class Awareness extends YouTubeBaseActivity implements OnInitializedListener {

    public static final String API_KEY = "AIzaSyChxMb4B2Gs99IEAcV3rhHAQEFMemcM0y8";
    public String VIDEO_ID = "hv6-COf0dWs";

    Toolbar customToolbar;
    YouTubePlayerView youtubePlayerView1, youtubePlayerView2, youtubePlayerView3, youtubePlayerView4, youtubePlayerView5, youtubePlayerView6, youtubePlayerView7, youtubePlayerView8, youtubePlayerView9;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awareness);
        customToolbar = findViewById(R.id.title);
        customToolbar.setTitleTextColor(getResources().getColor(R.color.light_font));

        youtubePlayerView1 = findViewById(R.id.Youtubeplayer);
        youtubePlayerView2 = findViewById(R.id.Youtubeplayer2);
        youtubePlayerView3 = findViewById(R.id.Youtubeplayer3);
        youtubePlayerView4 = findViewById(R.id.Youtubeplayer4);

        youtubePlayerView1.initialize(API_KEY,Awareness.this);
        youtubePlayerView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubePlayerView1.initialize(API_KEY,Awareness.this);
                VIDEO_ID = "hv6-COf0dWs";

            }
        });

        youtubePlayerView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubePlayerView2.initialize(API_KEY,Awareness.this);
                VIDEO_ID = "w5hlGac_ChQ";

            }
        });

        youtubePlayerView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubePlayerView3.initialize(API_KEY,Awareness.this);
                VIDEO_ID = "GGRvGdB-vuE";
            }
        });

        youtubePlayerView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubePlayerView4.initialize(API_KEY,Awareness.this);
                VIDEO_ID = "uMF-Tag3qy8";            }
        });
    }


    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        //add listeners to youtube player instance
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        //start buffering
        if(!b)
        {
                youTubePlayer.cueVideo(VIDEO_ID);

        }

    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    PlaybackEventListener playbackEventListener = new PlaybackEventListener()
    {

        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
}
