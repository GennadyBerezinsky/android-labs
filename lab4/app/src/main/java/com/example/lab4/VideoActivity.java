package com.example.lab4;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private Button play, pause, stop;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (VideoView) findViewById(R.id.videoView);
        play = (Button) findViewById(R.id.playButton);
        pause = (Button) findViewById(R.id.pauseButton);
        stop = (Button) findViewById(R.id.stopButton);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(video);
        videoView.stopPlayback();
        videoView.resume();
        videoView.pause();

    }

    public void playButtonListener(View view){
        videoView.start();
    }
    public void pauseButtonListener(View view){
        videoView.pause();
    }
    public void stopButtonListener(View view){
        videoView.stopPlayback();
        videoView.resume();
    }


}
