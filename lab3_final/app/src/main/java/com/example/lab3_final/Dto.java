package com.example.lab3_final;

public class Dto {
    String text;
    String answer;

    public Dto(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return text + " " + answer;
    }
}
