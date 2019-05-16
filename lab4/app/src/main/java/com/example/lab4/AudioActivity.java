package com.example.lab4;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class AudioActivity extends AppCompatActivity {

    SeekBar progress, volume;
    Button play, pause, stop;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        progress = (SeekBar) findViewById(R.id.progressbar);
        volume = (SeekBar) findViewById(R.id.volumeBar);

        play = (Button) findViewById(R.id.playButton);
        pause = (Button) findViewById(R.id.pauseButton);
        stop = (Button) findViewById(R.id.stopButton);

        player = MediaPlayer.create(this, R.raw.pepers);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

//just some change
    }

    public void playMusicButtonListener(View view){
        player.start();
    }
    public void pauseMusicButtonListener(View view){
        player.pause();
    }
    public void stopMusicButtonListener(View view){
        stopPlay();
    }

    private void stopPlay(){
        player.stop();
        try {
            player.prepare();
            player.seekTo(0);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
