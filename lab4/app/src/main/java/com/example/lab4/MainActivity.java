package com.example.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//<div>Icons made by <a href="https://www.flaticon.com/<?=_('authors').'/'?>gregor-cresnar" title="Gregor Cresnar">Gregor Cresnar</a> from <a href="https://www.flaticon.com/" 		    title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" 		    title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
//<div>Icons made by <a href="https://www.flaticon.com/<?=_('authors').'/'?>gregor-cresnar" title="Gregor Cresnar">Gregor Cresnar</a> from <a href="https://www.flaticon.com/" 		    title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" 		    title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>


public class MainActivity extends AppCompatActivity {

    Button audio, video, internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio = (Button) findViewById(R.id.audioButton);
        video = (Button) findViewById(R.id.videoButton);
        internet = (Button) findViewById(R.id.internetButton);

    }

    public void videoButtonListener(View view) {
        Intent gotoVideo = new Intent(this, VideoActivity.class);
        startActivity(gotoVideo);
    }

    public void audioButtonListener(View view) {
        Intent gotoAudio = new Intent(this, AudioActivity.class);
        startActivity(gotoAudio);
    }

    public void internetButtonListener(View view) {
        Intent gotoInternet = new Intent(this, VideoFromInternetActivity.class);
        startActivity(gotoInternet);
    }
}
