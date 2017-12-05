package com.example.thiendn.tempproject;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Created by thiendn on 11/30/17.
 */

public class GalleryActivity extends Activity {
    String url = "http://techslides.com/demos/sample-videos/small.mp4";

    SimpleExoPlayerView simpleExoPlayerView;
    SimpleExoPlayer player;
    private BandwidthMeter bandwidthMeter;
    private DataSource.Factory mediaDataSourceFactory;
    private DefaultTrackSelector trackSelector;

    ArrayList<Video> mVideos = new ArrayList<>();
    Gallery gallery;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        simpleExoPlayerView = findViewById(R.id.simple_exo_player_view);
        gallery = findViewById(R.id.gallery1);

        bandwidthMeter = new DefaultBandwidthMeter();
        mediaDataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "tempproject"), (TransferListener<? super DataSource>) bandwidthMeter);
        btnBack = (Button) findViewById(R.id.btn);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Back", Toast.LENGTH_LONG);
                onBack();
            }
        });
        initializeListVideo();
        initializeGallery();
    }

    private void onBack(){
        this.finish();
    }

    private void initializeGallery() {
        gallery.setSelection(15, true);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                releasePlayer();
                initializePlayer(url);
            }
        });
        gallery.setCallbackDuringFling(true);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                releasePlayer();
                initializePlayer(url);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Toast.makeText(GalleryActivity.this, "NOTHING", Toast.LENGTH_SHORT).show();
            }
        });
        gallery.setSelection(15, true);
    }

    private void initializeListVideo() {
        Video video1 = new Video(R.drawable.goku_1, url, "goku__1"); mVideos.add(video1);
        Video video2 = new Video(R.drawable.goku_2, url, "goku__2"); mVideos.add(video2);
        Video video3 = new Video(R.drawable.goku_3, url, "goku__3"); mVideos.add(video3);
        Video video4 = new Video(R.drawable.goku_1, url, "goku__1"); mVideos.add(video4);
        Video video5 = new Video(R.drawable.goku_2, url, "goku__2"); mVideos.add(video5);
        Video video6 = new Video(R.drawable.goku_3, url, "goku__3"); mVideos.add(video6);
        Video video7 = new Video(R.drawable.goku_1, url, "goku__1"); mVideos.add(video7);
        Video video8 = new Video(R.drawable.goku_2, url, "goku__2"); mVideos.add(video8);
        Video video9 = new Video(R.drawable.goku_3, url, "goku__3"); mVideos.add(video9);
        Video video10 = new Video(R.drawable.goku_1, url, "goku__1"); mVideos.add(video10);
        Video video11 = new Video(R.drawable.goku_2, url, "goku__2"); mVideos.add(video11);
        Video video12 = new Video(R.drawable.goku_3, url, "goku__3"); mVideos.add(video12);
        Video video13 = new Video(R.drawable.goku_1, url, "goku__1"); mVideos.add(video13);
        Video video14 = new Video(R.drawable.goku_2, url, "goku__2"); mVideos.add(video14);
        Video video15 = new Video(R.drawable.goku_3, url, "goku__3"); mVideos.add(video15);
        Video video16 = new Video(R.drawable.goku_1, url, "goku__1"); mVideos.add(video16);
        Video video17 = new Video(R.drawable.goku_2, url, "goku__2"); mVideos.add(video17);
        Video video18 = new Video(R.drawable.goku_3, url, "goku__3"); mVideos.add(video18);
        Video video19 = new Video(R.drawable.goku_1, url, "goku__1"); mVideos.add(video19);
        Video video20 = new Video(R.drawable.goku_2, url, "goku__2"); mVideos.add(video20);
        Video video21 = new Video(R.drawable.goku_3, url, "goku__3"); mVideos.add(video21);
        Video video22 = new Video(R.drawable.goku_1, url, "goku__1"); mVideos.add(video22);
        Video video23 = new Video(R.drawable.goku_2, url, "goku__2"); mVideos.add(video23);
        Video video24 = new Video(R.drawable.goku_3, url, "goku__3"); mVideos.add(video24);
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c) {
            context = c;
            // sets a grey background; wraps around the images
            TypedArray a =obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }
        // returns the number of images
        public int getCount() {
//            return imageIDs.length;
            return mVideos.size();
        }
        // returns the ID of an item
        public Object getItem(int position) {
            return mVideos.get(position);
        }
        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }
        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(mVideos.get(position).getThumbnail());
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 150));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }

    private class Video {
        int thumbnail;
        String url;
        String description;

        public Video(int thumbnail, String url, String description) {
            this.thumbnail = thumbnail;
            this.url = url;
            this.description = description;
        }

        public int getThumbnail() {
            return thumbnail;
        }

        public String getUrl() {
            return url;
        }

        public String getDescription() {
            return description;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer(url);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer(url);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
        }
    }

    private void releasePlayer() {
        if (player != null) {
            player.release();
            player = null;
            trackSelector = null;
        }
    }

    private void initializePlayer(String url) {
        simpleExoPlayerView.setControllerVisibilityListener(new PlaybackControlView.VisibilityListener() {
            @Override
            public void onVisibilityChange(int visibility) {
                switch (visibility) {
                    case VISIBLE:
                        gallery.setVisibility(VISIBLE);
                        break;
                    case GONE:
                        gallery.setVisibility(INVISIBLE);
                        break;
                }
            }
        });
        simpleExoPlayerView.requestFocus();

        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);

        trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        simpleExoPlayerView.setPlayer(player);

        player.setPlayWhenReady(true);
        DefaultExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

        MediaSource mediaSource = new ExtractorMediaSource(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"),
                mediaDataSourceFactory, extractorsFactory, null, null);

        player.prepare(mediaSource);
    }

}
