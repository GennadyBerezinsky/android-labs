package com.example.lab1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "class log MainActivity";
    private String mess = "";

    Button button;
    RadioButton option1, option2;
    EditText input;
    TextView output, header;
    RadioGroup radios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button1);
        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.textView1);
        header = (TextView) findViewById(R.id.textView2);

        radios = (RadioGroup) findViewById(R.id.radioGroup);
        radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.option1:
                        mess = "yes";
                        break;
                    case R.id.option2:
                        mess = "no";
                        break;
                    default:
                        break;

                }
            }
        });

    }

    private void showToastNotification(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }



    public void button1Listener(View view) {
        String inputText = input.getText().toString();
        if(inputText.length() == 0) {
            showToastNotification(getResources().getString(R.string.hint_noText));
            return;
        }
        if(mess.equals("")) {
            showToastNotification(getResources().getString(R.string.hint_option));
            return;
        }
        StringBuilder message = new StringBuilder("this is plain text:\n");
        message.append(inputText).append("\n").append("radio answer: ").append(mess).toString();
        output.setText(message);
    }
}
