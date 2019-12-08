package com.example.duanbvq.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanbvq.R;
import com.example.duanbvq.model.QuestionItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    TextView tvquestion;
    Button b_answer1,b_answer2,b_answer3,b_answer4;
    List<QuestionItem> questionItems;
    int currentQuestion=0;
    int correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Câu hỏi");
        setContentView(R.layout.activity_quiz);


        tvquestion=findViewById(R.id.question);
        b_answer2=findViewById(R.id.answer2);
        b_answer3=findViewById(R.id.answer3);
        b_answer4=findViewById(R.id.answer4);
        b_answer1=findViewById(R.id.answer1);

        loadAllQuestions();

        Collections.shuffle(questionItems);

        setQuestionScreen(currentQuestion);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItems.get(currentQuestion).getAnswer1().equals(questionItems.get(currentQuestion).getCorrect())){

                    correct++;
                    Toast.makeText(QuizActivity.this,"Đúng",Toast.LENGTH_SHORT).show();

                }else {
                    wrong++;
                    Toast.makeText(QuizActivity.this,"Sai"+questionItems.get(currentQuestion).getCorrect(),Toast.LENGTH_SHORT).show();

                }
                if (currentQuestion<questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                }
                else {
                    Intent intent=new Intent(getApplicationContext(),EndActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    startActivity(intent);
                    finish();
                }

            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItems.get(currentQuestion).getAnswer2().equals(questionItems.get(currentQuestion).getCorrect())){

                    correct++;
                    Toast.makeText(QuizActivity.this,"Đúng",Toast.LENGTH_SHORT).show();

                }else {
                    wrong++;
                    Toast.makeText(QuizActivity.this,"Sai"+questionItems.get(currentQuestion).getCorrect(),Toast.LENGTH_SHORT).show();

                }
                if (currentQuestion<questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                }
                else {
                    Intent intent=new Intent(getApplicationContext(),EndActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    startActivity(intent);
                    finish();
                }

            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItems.get(currentQuestion).getAnswer3().equals(questionItems.get(currentQuestion).getCorrect())){

                    correct++;
                    Toast.makeText(QuizActivity.this,"Đúng",Toast.LENGTH_SHORT).show();

                }else {
                    wrong++;
                    Toast.makeText(QuizActivity.this,"Sai"+questionItems.get(currentQuestion).getCorrect(),Toast.LENGTH_SHORT).show();

                }
                if (currentQuestion<questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                }
                else {
                    Intent intent=new Intent(getApplicationContext(),EndActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    startActivity(intent);
                    finish();
                }

            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItems.get(currentQuestion).getAnswer4().equals(questionItems.get(currentQuestion).getCorrect())){

                    correct++;
                    Toast.makeText(QuizActivity.this,"Đúng",Toast.LENGTH_SHORT).show();

                }else {
                    wrong++;
                    Toast.makeText(QuizActivity.this,"Sai"+questionItems.get(currentQuestion).getCorrect(),Toast.LENGTH_SHORT).show();

                }
                if (currentQuestion<questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                }
                else {
                    Intent intent=new Intent(getApplicationContext(),EndActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    startActivity(intent);
                    finish();
                }

            }
        });



    }

    private void setQuestionScreen(int number){
        tvquestion.setText(questionItems.get(number).getQuestion());
        b_answer1.setText(questionItems.get(number).getAnswer1());
        b_answer2.setText(questionItems.get(number).getAnswer2());
        b_answer3.setText(questionItems.get(number).getAnswer3());
        b_answer4.setText(questionItems.get(number).getAnswer4());

    }
    private void loadAllQuestions(){
        questionItems=new ArrayList<>();
        String jsonStr=loadJSONFromAsset("question1.json");

        try {
            JSONObject jsonObj=new JSONObject(jsonStr);
            JSONArray questions=jsonObj.getJSONArray("questions");
            for (int i=0;i<questions.length();i++){
                JSONObject question=questions.getJSONObject(i);

                String questionString=question.getString("question");
                String answer1String=question.getString("answer1");
                String answer2String=question.getString("answer2");
                String answer3String=question.getString("answer3");
                String answer4String=question.getString("answer4");
                String correctString=question.getString("correct");

                questionItems.add(new QuestionItem(
                        questionString,
                        answer1String,
                        answer2String,
                        answer3String,
                        answer4String,
                        correctString
                ));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    private String loadJSONFromAsset(String file){
        String json="";
        try {
            InputStream is=getAssets().open(file);
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            json=new String(buffer,"UTF-8");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
}


