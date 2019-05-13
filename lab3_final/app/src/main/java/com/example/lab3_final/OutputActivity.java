package com.example.lab3_final;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class OutputActivity extends AppCompatActivity {

    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        System.out.println("On Create");
        textView = findViewById(R.id.textView);
        Dao dao = new Dao(getBaseContext());
        List<Dto> result = dao.findAll();
        if(result.size() == 0) {
            textView.setText("Nothing to show");
        }
        else {
            StringBuilder builder = new StringBuilder();
            for(Dto item : result) {
                builder.append(item.text + " " + item.answer+ "\n");
            }
            textView.setText(builder.toString());
        }
    }
}
