package com.karaapp.karaokeapp.mdl;

/**
 * Created com.karaapp.karaokeapp.ui.Mdl on 5/3/2017.
 * Author: NgaNQ
 */

public class QuestionMdl {
    public QuestionMdl(int numbers, String question) {
        this.numbers = numbers;
        this.question = question;
    }

    public int getNumbers() {

        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private int numbers;
    private String question;
}
