package com.example.duanbvq.presenter;

import com.example.duanbvq.interfaces.QuizView;

public class QuizPresenter  {
    private QuizView quizView;
    public QuizPresenter(QuizView quizView){
        this.quizView=quizView;
    }
    public void openStart(){
        quizView.navigate_start();
    }
}
