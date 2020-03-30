package com.example.bmicalculator.Activites;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.Data.Questions;
import com.example.bmicalculator.R;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    Button back;
    Button answer1, answer2, answer3, answer4;
    TextView score, question;

    private Questions mQuestions = new Questions();
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLenght = mQuestions.mQuestions.length;

    Random r = new Random();

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        back = findViewById(R.id.quiz_back);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        updateQuestion(r.nextInt(mQuestionsLenght));
        score.setText(String.format("Score: %d", mScore));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
            }
        });

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(answer1);
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(answer2);
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(answer3);
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(answer4);
            }
        });

    }

    @SuppressLint("DefaultLocale")
    private void play(Button button){
        if(button.getText() == mAnswer){
            mScore++;
            score.setText(String.format("Score: %d", mScore));
            updateQuestion(r.nextInt(mQuestionsLenght));
        }
        else {
            gameOver();
        }
    }
    private void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizActivity.this);
        alertDialogBuilder
                .setMessage("Game over, your score is " + mScore + " points." )
                .setCancelable(false)
                .setPositiveButton("New game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("Exit",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
