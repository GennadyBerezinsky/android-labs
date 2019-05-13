package com.example.lab3_final;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;



public class InputFragment extends Fragment {


    private String mess = "";


    Button button, outputButton;
    RadioButton option1, option2;
    EditText input;
    TextView header;
    RadioGroup radios;


    private OnFragmentInteractionListener mListener;

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String link);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        button = (Button) view.findViewById(R.id.button1);
        option1 = (RadioButton) view.findViewById(R.id.option1);
        option2 = (RadioButton) view.findViewById(R.id.option2);
        input = (EditText) view.findViewById(R.id.input);
        header = (TextView) view.findViewById(R.id.textView2);
        outputButton = (Button) view.findViewById(R.id.button_output);
        radios = (RadioGroup) view.findViewById(R.id.radioGroup);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                String inputText = input.getText().toString();
                if(inputText.length() == 0) {
                    return;
                }
                if(mess.equals("")) {
                    return;
                }
                StringBuilder message = new StringBuilder("this is plain text:\n");
                String resMes = message.append(inputText).append("\n").append("radio answer: ").append(mess).toString();
                Dao dao = new Dao(getContext());
                String toast = dao.create(new Dto(inputText, mess));
                System.out.println(toast);
                System.out.println("mes created");
                mListener.onFragmentInteraction(resMes);
            }
        });

        outputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OutputActivity.class);
                startActivity(intent);
            }
        });

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
        return view;
    }









    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    public void updateOutput() {
        StringBuilder message = new StringBuilder("this is plain text:\n");
        String inputText = input.getText().toString();
        String mes = message.append(inputText).append("\n").append("radio answer: ").append(mess).toString();
        mListener.onFragmentInteraction(mes);
    }

}
