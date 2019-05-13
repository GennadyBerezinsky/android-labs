package com.example.lab3_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onFragmentInteraction(String link) {

        OutputFragment fragment = (OutputFragment) getFragmentManager().findFragmentById(R.id.output_fragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(link);
        }
    }
}

