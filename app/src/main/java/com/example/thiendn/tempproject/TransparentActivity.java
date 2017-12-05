package com.example.thiendn.tempproject;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

/**
 * Created by thiendn on 11/29/17.
 */

public class TransparentActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);

        SimpleExoPlayerView simpleExoPlayerView = findViewById(R.id.simple_exo_player_view);
        // Produces DataSource instances through which media data is loaded.
        String userAgent = Util.getUserAgent(this, "TempProject");
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                userAgent);
        // Produces Extractor instances for parsing the media data.
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        // This is the MediaSource representing the media to be played.
        Uri mp4VideoUri = Uri.parse("https://s3-ap-southeast-1.amazonaws.com/sin-region/alerts-video/2017/11/26/client-1148/937114/2017-11-27%2004-36-59%20-%20%20AFR20-Employee%20did%20not%20APPROACH%20to%20client%20after%2015%20seconds-2017-11-26-16h52.mp4?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJG4AXR5IKUCPEUYQ%2F20171129%2Fap-southeast-1%2Fs3%2Faws4_request&X-Amz-Date=20171129T071625Z&X-Amz-SignedHeaders=host&X-Amz-Expires=28800&X-Amz-Signature=e22478a921ef20349f9846626b3831356fccde1965e7206a8ec5261f6ae2deae");
        MediaSource videoSource = new ExtractorMediaSource(mp4VideoUri,
                dataSourceFactory, extractorsFactory, null, null);

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);

        SimpleExoPlayer player =
                ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        player.prepare(videoSource);
        player.setPlayWhenReady(true);
        simpleExoPlayerView.setPlayer(player);
    }
}
