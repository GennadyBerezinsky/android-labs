package com.example.lab2_final;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OutputFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_output, container, false);
        return view;
    }


    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.textView1);
        view.setText(item);
    }
}
