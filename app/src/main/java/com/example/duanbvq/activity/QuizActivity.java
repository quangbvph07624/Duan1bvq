package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {
    TextView tvquestion;
    TextView tvTime;
    Button b_answer1, b_answer2, b_answer3, b_answer4, btnstart;
    List<QuestionItem> questionItems;
    CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    int currentQuestion = 0;
    int correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Câu hỏi");
        setContentView(R.layout.activity_quiz);
        tvTime = findViewById(R.id.tvtimer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnstart = findViewById(R.id.btnstart);
        tvquestion = findViewById(R.id.question);
        b_answer2 = findViewById(R.id.answer2);
        b_answer3 = findViewById(R.id.answer3);
        b_answer4 = findViewById(R.id.answer4);
        b_answer1 = findViewById(R.id.answer1);


        loadAllQuestions();

        Collections.shuffle(questionItems);

        setQuestionScreen(currentQuestion);

        setTime();

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItems.get(currentQuestion).getAnswer1().equals(questionItems.get(currentQuestion).getCorrect())) {

                    correct++;
                    Toast.makeText(QuizActivity.this, "Đúng", Toast.LENGTH_SHORT).show();

                } else {
                    wrong++;
                    Toast.makeText(QuizActivity.this, "Sai! " + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();

                }
                if (currentQuestion < questionItems.size() - 1) {
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }

            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItems.get(currentQuestion).getAnswer2().equals(questionItems.get(currentQuestion).getCorrect())) {

                    correct++;
                    Toast.makeText(QuizActivity.this, "Đúng", Toast.LENGTH_SHORT).show();

                } else {
                    wrong++;
                    Toast.makeText(QuizActivity.this, "Sai! " + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();

                }
                if (currentQuestion < questionItems.size() - 1) {
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }

            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItems.get(currentQuestion).getAnswer3().equals(questionItems.get(currentQuestion).getCorrect())) {

                    correct++;
                    Toast.makeText(QuizActivity.this, "Đúng", Toast.LENGTH_SHORT).show();

                } else {
                    wrong++;
                    Toast.makeText(QuizActivity.this, "Sai! " + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();

                }
                if (currentQuestion < questionItems.size() - 1) {
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }

            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionItems.get(currentQuestion).getAnswer4().equals(questionItems.get(currentQuestion).getCorrect())) {

                    correct++;
                    Toast.makeText(QuizActivity.this, "Đúng", Toast.LENGTH_SHORT).show();

                } else {
                    wrong++;
                    Toast.makeText(QuizActivity.this, "Sai! " + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();

                }
                if (currentQuestion < questionItems.size() - 1) {
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setTime();
    }

    private void setQuestionScreen(int number) {
        tvquestion.setText(questionItems.get(number).getQuestion());
        b_answer1.setText(questionItems.get(number).getAnswer1());
        b_answer2.setText(questionItems.get(number).getAnswer2());
        b_answer3.setText(questionItems.get(number).getAnswer3());
        b_answer4.setText(questionItems.get(number).getAnswer4());

    }

    private void loadAllQuestions() {
        questionItems = new ArrayList<>();
        String jsonStr = loadJSONFromAsset("question1.json");

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray questions = jsonObj.getJSONArray("questions");
            for (int i = 0; i < questions.length(); i++) {
                JSONObject question = questions.getJSONObject(i);

                String questionString = question.getString("question");
                String answer1String = question.getString("answer1");
                String answer2String = question.getString("answer2");
                String answer3String = question.getString("answer3");
                String answer4String = question.getString("answer4");
                String correctString = question.getString("correct");

                questionItems.add(new QuestionItem(
                        questionString,
                        answer1String,
                        answer2String,
                        answer3String,
                        answer4String,
                        correctString
                ));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJSONFromAsset(String file) {
        String json = "";
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    public void setTime() {


        new CountDownTimer(600000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTime.setText((millisUntilFinished / 1000) /60 +" : "+(millisUntilFinished/1000)%60);
            }

            public void onFinish() {
                Intent intent = new Intent(QuizActivity.this, EndActivity.class);
                intent.putExtra("correct", correct);
                intent.putExtra("wrong", wrong);
                startActivity(intent);
            }
        }.start();

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(QuizActivity.this)
                        .setTitle("Thông báo")
                        .setMessage("Bạn chưa hoàn thành bài thi ! Bài thi của bạn sẽ bị hủy ?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(QuizActivity.this, WaitTracnghiemActivity.class);


                                startActivity(intent);


                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setCancelable(false);
                alertDialog.show();
//                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}




